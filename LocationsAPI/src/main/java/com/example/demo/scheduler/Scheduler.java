package com.example.demo.scheduler;

import com.example.demo.entity.model.Location;
import com.example.demo.services.interfaces.LocationsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Scheduler {

    @Autowired
    private LocationsService locationsService;

    @Scheduled(fixedRate = 3600000)
    public void updateLocations() throws IOException {
        System.out.println("Job started");
        locationsService.updateLocations();
    }
}
