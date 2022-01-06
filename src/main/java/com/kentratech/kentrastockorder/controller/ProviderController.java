package com.kentratech.kentrastockorder.controller;

import com.kentratech.kentrastockorder.entity.Provider;
import com.kentratech.kentrastockorder.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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

    @PostMapping(value = "/save")
    public ResponseEntity<Void> save(@RequestBody Provider obj){
        obj = providerService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        providerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Provider>> findAll(){
        List<Provider> list = providerService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Provider obj, @PathVariable Long id){
        obj.setId(id);
        obj = providerService.update(obj);
        return ResponseEntity.noContent().build();

    }

}
