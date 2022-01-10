package com.kentratech.kentrastockorder.controller;

import com.kentratech.kentrastockorder.entity.Provider;
import com.kentratech.kentrastockorder.response.CustomResponse;
import com.kentratech.kentrastockorder.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        providerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/list")
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

    @GetMapping
    public ResponseEntity<CustomResponse<Provider>> getProviders(@RequestParam(name = "sort", defaultValue = "id,ASC", required = false) String orderBy,
                                                                 @RequestParam(name = "code", defaultValue = "", required = false) String code,
                                                                 @RequestParam(name = "name", defaultValue = "", required = false) String name,
                                                                 @RequestParam(name = "page", defaultValue = "1", required = false) Integer pageNumber,
                                                                 @RequestParam(name = "sort", defaultValue = "30", required = false) Integer pageSize){

        String[] parseOrder = orderBy.split(",");
        Sort sort = Sort.by(Sort.Direction.fromOptionalString(parseOrder[1]).get(), parseOrder[0]);
        Page<Provider> list = providerService.getProviders(sort, code, name, pageNumber, pageSize);
        return ResponseEntity.ok(new CustomResponse<>(list));

    }

}
