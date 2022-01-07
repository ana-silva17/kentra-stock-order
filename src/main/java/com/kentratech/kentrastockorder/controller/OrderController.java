package com.kentratech.kentrastockorder.controller;

import com.kentratech.kentrastockorder.entity.Order;
import com.kentratech.kentrastockorder.entity.Provider;
import com.kentratech.kentrastockorder.service.OrderService;
import com.kentratech.kentrastockorder.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{id}")
    private ResponseEntity<Order> findById(@PathVariable("id") Long id){
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }




}
