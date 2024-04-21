package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final Adapter adapter;

    @GetMapping("/testGoodRequest")
    public ResponseEntity<Void> testGoodRequest(@RequestBody CreateOrderRequest createOrderRequest){
        adapter.createOrder(createOrderRequest);
        adapter.sendNotification("/notification");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/testBadRequest")
    public ResponseEntity<Void> testBadRequest(@RequestBody CreateOrderRequest createOrderRequest){
        String orderId = adapter.createOrder(createOrderRequest).getBody().toString();
        try{
            adapter.sendNotification("/testRollback");
        } catch(Exception e){
            adapter.rollbackRequest(Long.parseLong(orderId));
        }
        return ResponseEntity.noContent().build();
    }
}
