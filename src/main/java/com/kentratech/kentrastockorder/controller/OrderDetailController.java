package com.kentratech.kentrastockorder.controller;

import com.kentratech.kentrastockorder.entity.OrderDetail;
import com.kentratech.kentrastockorder.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orderDetails")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping(value = "/{id}")
    private ResponseEntity<OrderDetail> findById(@PathVariable("id") Long id){
        OrderDetail orderDetail = orderDetailService.findById(id);
        return ResponseEntity.ok().body(orderDetail);
    }
}
