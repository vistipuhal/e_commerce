package in.example.omnicuris.restapi.service.impl;


import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.example.omnicuris.restapi.model.Order;
import in.example.omnicuris.restapi.repository.OrderRepository;
import in.example.omnicuris.restapi.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public String create(Order order) {
        order.setDateCreated(LocalDate.now());
        this.orderRepository.save(order);
        return "Order saved";
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }
}
