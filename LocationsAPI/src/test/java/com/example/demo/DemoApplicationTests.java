package com.example.demo;

import com.example.demo.entity.model.Location;
import com.example.demo.services.interfaces.LocationsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Fail.fail;
import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private LocationsService locationsService;

    @Test
    public void contextLoads() {
    }

    private static final String WEBSITE_LINK = "http://iasi.inoras.ro/locuri/";

    @Test
    public void whenApiIsCalled_WithPage1_ThenHttpStatusReturned_ShouldBe_200() {
        try {
            URL url = new URL(WEBSITE_LINK + "1/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            assertThat(conn.getResponseCode()).isEqualTo(200);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenApiIsCalled_WithPage2_ThenHttpStatusReturned_ShouldBe_200() {
        try {
            URL url = new URL(WEBSITE_LINK + "2/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            assertThat(conn.getResponseCode()).isEqualTo(200);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenApiIsCalled_WithPage3_ThenHttpStatusReturned_ShouldBe_200() {
        try {
            URL url = new URL(WEBSITE_LINK + "3/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            assertThat(conn.getResponseCode()).isEqualTo(200);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenApiIsCalled_WithPage4_ThenHttpStatusReturned_ShouldBe_200() {
        try {
            URL url = new URL(WEBSITE_LINK + "4/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            assertThat(conn.getResponseCode()).isEqualTo(200);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenApiIsCalled_WithPage5_ThenHttpStatusReturned_ShouldBe_200() {
        try {
            URL url = new URL(WEBSITE_LINK + "5/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            assertThat(conn.getResponseCode()).isEqualTo(200);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void when_getLocationsFromIasi_IsCalled_ReturnedListOfLocations_ShouldNotBe_Null() throws IOException {
        List<Location> locations = locationsService.getLocationsFromIasi();

        assertThat(locations).isNotNull();
    }

    @Test
    public void when_geteLocationsFromIasi_IsCalled_NoException_ShouldBe_Thrown(){
        try{
            locationsService.getLocationsFromIasi();
        }
        catch(Exception e){
            fail("Should not have thrown any exception");
        }
    }
}
