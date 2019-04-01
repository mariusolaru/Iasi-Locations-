package com.example.demo.services.interfaces;

import com.example.demo.entity.model.Location;

import java.io.IOException;
import java.util.List;

public interface LocationsService {

    List<Location> getLocationsFromIasi() throws IOException;

    void updateLocations() throws IOException;

}
