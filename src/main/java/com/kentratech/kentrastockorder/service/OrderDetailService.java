package com.kentratech.kentrastockorder.service;

import com.kentratech.kentrastockorder.entity.OrderDetail;
import com.kentratech.kentrastockorder.repository.OrderDetailRepository;
import com.kentratech.kentrastockorder.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public OrderDetail findById(Long id) {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);
        return orderDetail.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public OrderDetail save(OrderDetail obj) {
        obj.setId(null);
        return orderDetailRepository.save(obj);
    }
}
