package com.example.demo.hello;

import com.example.demo.entity.model.Location;
import com.example.demo.services.interfaces.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    LocationsService locationsService;

    @MessageMapping("/helloWorld")
    @SendTo("/topic/scrappAll")
    public @ResponseBody List<Location> getLocations() throws Exception
    {
        Thread.sleep(1000);
        return locationsService.getLocationsFromIasi();
    }


    @MessageMapping("/hello")
    @SendTo("/topic/scrapp")
    public String updateLocations() throws Exception
    {
        locationsService.updateLocations();
        return "job done";
    }

}
