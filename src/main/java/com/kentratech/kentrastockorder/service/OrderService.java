package com.kentratech.kentrastockorder.service;

import com.kentratech.kentrastockorder.entity.Order;
import com.kentratech.kentrastockorder.entity.Provider;
import com.kentratech.kentrastockorder.repository.OrderRepository;
import com.kentratech.kentrastockorder.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}