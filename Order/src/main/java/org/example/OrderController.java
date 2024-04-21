package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderServiceImpl orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    @PostMapping("/orders")
    public ResponseEntity<Long> createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        return ResponseEntity.ok(orderService.createOrder(createOrderRequest));

    }
    @DeleteMapping("/rollback/orders")
    public ResponseEntity<Void> rollbackOrder(@RequestParam("id") Long rollbackOrderRequest){
        orderService.rollbackOrder(rollbackOrderRequest);
        return ResponseEntity.noContent().build();
    }


}
