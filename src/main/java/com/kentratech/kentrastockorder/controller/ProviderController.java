package com.kentratech.kentrastockorder.controller;

import com.kentratech.kentrastockorder.entity.Provider;
import com.kentratech.kentrastockorder.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping(value = "/{id}")
    private ResponseEntity<Provider> findById(@PathVariable("id") Long id){
        Provider provider = providerService.findById(id);
        return ResponseEntity.ok().body(provider);
    }

}
