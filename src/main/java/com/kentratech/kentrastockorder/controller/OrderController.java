package com.kentratech.kentrastockorder.controller;

import com.kentratech.kentrastockorder.entity.Order;
import com.kentratech.kentrastockorder.entity.Provider;
import com.kentratech.kentrastockorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }


}
