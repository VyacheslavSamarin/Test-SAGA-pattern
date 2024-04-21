package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    @Override
    public Long createOrder(CreateOrderRequest createOrderRequest) {
        return orderRepository.save(orderMapper.toEntity(createOrderRequest)).getId();

    }

    @Override
    public void rollbackOrder(Long rollbackOrderRequest) {
        orderRepository.deleteById(rollbackOrderRequest);

    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).collect(Collectors.toList());
    }
}
