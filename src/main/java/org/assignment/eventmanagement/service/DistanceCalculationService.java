package org.assignment.eventmanagement.service;

import org.springframework.stereotype.Service;
    import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class DistanceCalculationService {

    public double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2) throws IOException {

        String DISTANCE_API_URL = "https://gg-backend-assignment.azurewebsites.net/api/Distance?code=IAKvV2EvJa6Z6dEIUqqd7yGAu7IZ8gaH-a0QO6btjRc1AzFu8Y3IcQ==";
        String requestUrl = DISTANCE_API_URL + "&latitude1=" + latitude1 + "&longitude1=" + longitude1 +
                            "&latitude2=" + latitude2 + "&longitude2=" + longitude2;


        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(requestUrl, String.class);

        return parseDistanceFromJson(response);
    }

    public double parseDistanceFromJson(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(jsonString);
        String distanceString = node.get("distance").asText();
        return Double.parseDouble(distanceString);
    }

}
