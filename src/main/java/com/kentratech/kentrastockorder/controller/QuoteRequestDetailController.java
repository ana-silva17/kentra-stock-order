package com.kentratech.kentrastockorder.controller;

import com.kentratech.kentrastockorder.entity.OrderDetail;
import com.kentratech.kentrastockorder.entity.QuoteRequestDetail;
import com.kentratech.kentrastockorder.repository.QuoteRequestDetailRepository;
import com.kentratech.kentrastockorder.service.QuoteRequestDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/quoteRequestDetails")
public class QuoteRequestDetailController {

    @Autowired
    private QuoteRequestDetailService quoteRequestDetailService;

    @GetMapping(value = "/{id}")
    private ResponseEntity<QuoteRequestDetail> findById(@PathVariable("id") Long id){
        QuoteRequestDetail quoteRequestDetail = quoteRequestDetailService.findById(id);
        return ResponseEntity.ok().body(quoteRequestDetail);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Void> save(@RequestBody QuoteRequestDetail obj){
        obj = quoteRequestDetailService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
