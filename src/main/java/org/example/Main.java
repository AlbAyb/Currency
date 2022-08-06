package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();


        String url = "https://www.cbr-xml-daily.ru/daily_json.js";
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response);
        JsonNode valute = jsonNode.get("Valute");
        System.out.println(jsonNode.findValue("Date"));
        for (JsonNode node : valute) {
            System.out.println(node.findValue("Name") + ":" + node.findValue("Value"));
        }
    }
}
