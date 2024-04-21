package org.example;

import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderEntity toEntity(CreateOrderRequest createOrderRequest){
        return OrderEntity
                .builder()
                .price(createOrderRequest.getPrice())
                .products(createOrderRequest.getProducts())
                .build();
    }
    public OrderDto toDto(OrderEntity orderEntity){
        return OrderDto
                .builder()
                .id(orderEntity.getId())
                .price(orderEntity.getPrice())
                .products(orderEntity.getProducts())
                .build();
    }
}
