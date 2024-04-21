package org.example;

import java.util.List;

public interface OrderService {
    Long createOrder(CreateOrderRequest createOrderRequest);
    void rollbackOrder(Long id);

    List<OrderDto> getAllOrders();
}
