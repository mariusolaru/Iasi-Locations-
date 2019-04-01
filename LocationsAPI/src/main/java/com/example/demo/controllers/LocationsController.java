package com.example.demo.controllers;

import com.example.demo.entity.model.Location;
import com.example.demo.services.interfaces.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "locations")
public class LocationsController {

    @Autowired
    LocationsService locationsService;

    @GetMapping
    public @ResponseBody ResponseEntity<List<Location>> getLocations() throws IOException {
        List<Location> locations = locationsService.getLocationsFromIasi();
        return new ResponseEntity<>(locations, org.springframework.http.HttpStatus.OK);
    }

    @GetMapping(value = "/update")
    public void updateLocations() throws IOException {
        locationsService.updateLocations();
    }

}