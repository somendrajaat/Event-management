package org.assignment.eventmanagement.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;

    import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class WeatherService {

    public String parseWeatherFromJson(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(jsonString);
        String weather = node.get("weather").asText();
        return weather;
    }


    public String getWeather(String city, LocalDate date) throws IOException {
        String WEATHER_API_URL = "https://gg-backend-assignment.azurewebsites.net/api/Weather?code=KfQnTWHJbg1giyB_Q9Ih3Xu3L9QOBDTuU5zwqVikZepCAzFut3rqsg==";
        String requestUrl = WEATHER_API_URL + "&city=" + city + "&date=" + date.toString();
        RestTemplate restTemplate = new RestTemplate();
        return parseWeatherFromJson(restTemplate.getForObject(requestUrl, String.class));

    }
}
