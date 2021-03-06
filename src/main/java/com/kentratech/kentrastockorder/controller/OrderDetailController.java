package com.kentratech.kentrastockorder.controller;

import com.kentratech.kentrastockorder.entity.OrderDetail;
import com.kentratech.kentrastockorder.entity.QuoteRequestDetail;
import com.kentratech.kentrastockorder.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @PostMapping(value = "/save")
    public ResponseEntity<Void> save(@RequestBody OrderDetail obj){
        obj = orderDetailService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        orderDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<OrderDetail>> findAll(){
        List<OrderDetail> list = orderDetailService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
