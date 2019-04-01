package com.example.demo.services;

import com.example.demo.entity.model.Location;
import com.example.demo.repository.LocationsRepository;
import com.example.demo.services.interfaces.LocationsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LocationsServiceImpl implements LocationsService {

    private static final String WEBSITE_LINK = "http://iasi.inoras.ro/locuri/";

    @Autowired
    private LocationsRepository locationsRepository;

    @Override
    public List<Location> getLocationsFromIasi() throws IOException {
        return locationsRepository.findAll();
    }

    @Override
    public void updateLocations() throws IOException {
        locationsRepository.deleteAll();

        List<Location> locations = new ArrayList<>();

        for(int i = 1 ; i <= 5; i++ ){
            Document doc = null;

            doc = Jsoup.connect(WEBSITE_LINK + i + "/").get();

            Elements elements = doc.select("ul.loc_list > li");

            for (int j = 0; j < elements.size(); j++) {
                Location location = new Location();
                location.setName(elements.get(j).select("h2").text());
                location.setLink(elements.get(j).select("h2").select("a").attr("href"));
                location.setInfo(elements.get(j).select("p").text());
                location.setLastUpdatedDate(new Date());

                locations.add(location);
            }
        }
        locationsRepository.saveAll(locations);
    }
}
