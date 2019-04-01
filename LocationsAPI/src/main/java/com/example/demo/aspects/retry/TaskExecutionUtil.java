package com.example.demo.aspects.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskExecutionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskExecutionUtil.class);

    public static <T> T execute(Task<T> task,
                                int noOfRetryAttempts,
                                long sleepInterval,
                                Class<? extends Throwable>... ignoreExceptions){

        LOGGER.debug("noOfRetryAttempts = " + noOfRetryAttempts);

        if (noOfRetryAttempts < 1) {
            noOfRetryAttempts = 1;
        }

        T result = null;

        for (int retryCount = 1; retryCount <= noOfRetryAttempts; retryCount++){
            LOGGER.debug("Executing the task. Attemp:" + retryCount);
            try {
                result = task.execute();
                break;
            } catch (Exception e){
                Throwable t = e.getCause();
                LOGGER.error("Caught Exception class " + e.getClass());
                LOGGER.error("Failed at Retry attempt :" + retryCount + " of : " + noOfRetryAttempts);

                if (retryCount >= noOfRetryAttempts) {
                    LOGGER.error("Maximum retrial attempts exceeded");
                    LOGGER.error("Throwing exception to the caller");
                    throw e;
                }

                try {
                    Thread.sleep(sleepInterval);
                } catch (InterruptedException e1) {

                }
            }
        }

        return result;
    }

}
