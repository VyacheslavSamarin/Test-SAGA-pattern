package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Adapter {
    private final RestTemplate restTemplate;

    private String notificationsUrl = "http://localhost:9091/api/v1";


    private String orderUrl = "http://localhost:9090/api/v1";

    public Adapter(RestTemplateBuilder builder){
        restTemplate = builder.build();
    }

    public ResponseEntity<String> createOrder(CreateOrderRequest createOrderRequest){
        return restTemplate.postForEntity(
                orderUrl + "/orders", createOrderRequest, String.class
        );
    }

    public String sendNotification(String url){
        return restTemplate.getForObject(notificationsUrl + url, String.class);
    }

    public String rollbackRequest(Long rollbackOrderRequest) {
        String url = orderUrl + "/rollback/orders"+"?id="+rollbackOrderRequest;
        ResponseEntity<String> response = restTemplate.exchange(
                orderUrl + "/rollback/orders" + "?id=" + rollbackOrderRequest,
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                String.class
        );
        return response.toString();
    }
}
