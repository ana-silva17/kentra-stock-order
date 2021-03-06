package com.kentratech.kentrastockorder.service;

import com.kentratech.kentrastockorder.entity.OrderDetail;
import com.kentratech.kentrastockorder.entity.QuoteRequestDetail;
import com.kentratech.kentrastockorder.repository.OrderDetailRepository;
import com.kentratech.kentrastockorder.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void delete(Long id) {
        try {
            orderDetailRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public List<OrderDetail> findAll(){

        return orderDetailRepository.findAll();
    }
}
