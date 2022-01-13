package com.kentratech.kentrastockorder.controller;

import com.kentratech.kentrastockorder.entity.QuoteRequestDetail;
import com.kentratech.kentrastockorder.service.QuoteRequestDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
