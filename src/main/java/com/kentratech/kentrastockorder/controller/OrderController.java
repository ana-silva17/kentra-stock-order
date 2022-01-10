package com.kentratech.kentrastockorder.controller;

import com.kentratech.kentrastockorder.entity.Order;
import com.kentratech.kentrastockorder.entity.Provider;
import com.kentratech.kentrastockorder.response.CustomResponse;
import com.kentratech.kentrastockorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/list")
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<CustomResponse<Order>> getOrders(@RequestParam(name = "sort", defaultValue = "id,DESC", required = false) String order,
                                                           @RequestParam(name = "dateFrom", defaultValue = "", required = false) String dateFrom,
                                                           @RequestParam(name = "dateTo", defaultValue = "", required = false) String dateTo,
                                                           @RequestParam(name = "page", defaultValue = "1", required = false) Integer pageNumber,
                                                           @RequestParam(name = "size", defaultValue = "30", required = false) Integer pageSize) {

        String[] parseOrder = order.split(",");
        Sort sort = Sort.by(Sort.Direction.fromOptionalString(parseOrder[1]).get(), parseOrder[0]);
        Page<Order> list = orderService.getOrders(sort, dateFrom, dateTo, pageNumber, pageSize);
        return ResponseEntity.ok(new CustomResponse<>(list));
    }

}
