package com.kentratech.kentrastockorder.controller;

import com.kentratech.kentrastockorder.entity.Order;
import com.kentratech.kentrastockorder.entity.QuoteRequest;
import com.kentratech.kentrastockorder.service.OrderService;
import com.kentratech.kentrastockorder.service.QuoteRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/quotes")
public class QuoteRequestController {

    @Autowired
    private QuoteRequestService quoteRequestService;

    @GetMapping(value = "/{id}")
    private ResponseEntity<QuoteRequest> findById(@PathVariable("id") Long id){
        QuoteRequest quoteRequest = quoteRequestService.findById(id);
        return ResponseEntity.ok().body(quoteRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        quoteRequestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
