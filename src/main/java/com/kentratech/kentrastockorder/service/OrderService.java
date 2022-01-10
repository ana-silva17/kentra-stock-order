package com.kentratech.kentrastockorder.service;

import com.kentratech.kentrastockorder.entity.Order;
import com.kentratech.kentrastockorder.repository.OrderRepository;
import com.kentratech.kentrastockorder.repository.OrderRepositorySpec;
import com.kentratech.kentrastockorder.repository.ProviderRepositorySpec;
import com.kentratech.kentrastockorder.service.exceptions.ResourceNotFoundException;
import com.kentratech.kentrastockorder.specification.OrderSpecification;
import com.kentratech.kentrastockorder.specification.ProviderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderRepositorySpec orderRepositorySpec;

    @Autowired
    private OrderSpecification orderSpecification;

    public OrderService() {
    }


    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public List<Order> findAll(){

        return orderRepository.findAll();
    }

    public Page<Order> getOrders(Sort sort, String code, String dateFrom, String dateTo, Integer pageNumber, Integer pageSize) {

        Pageable p = PageRequest.of(pageNumber -1 , pageSize, sort);
        return orderRepositorySpec.findAll(Specification.where(
                this.orderSpecification.findByBetweenDate(dateFrom, dateTo)
                .and(this.orderSpecification.findByCode(code))),p);
    }
}
