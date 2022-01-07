package com.kentratech.kentrastockorder.service;

import com.kentratech.kentrastockorder.entity.Provider;

import com.kentratech.kentrastockorder.repository.OrderRepository;
import com.kentratech.kentrastockorder.repository.ProviderRepository;

import com.kentratech.kentrastockorder.repository.QuoteRequestRepository;
import com.kentratech.kentrastockorder.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private QuoteRequestRepository quoteRequestRepository;

    public Provider findById(Long id) {
        Optional<Provider> provider = providerRepository.findById(id);
        return provider.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Provider save(Provider obj) {
        obj.setId(null);
        obj.setCode(obj.getCode());
        obj.setName(obj.getName());
        obj.setNif(obj.getNif());
        obj.setAddress(obj.getAddress());
        obj.setPhone(obj.getPhone());
        obj.setEmail(obj.getEmail());
        obj.getOrder().setProvider(obj);
        obj.getQuoteRequest().setProvider(obj);
        obj = providerRepository.save(obj);
        orderRepository.save(obj.getOrder());
        quoteRequestRepository.save(obj.getQuoteRequest());
        return obj;
//        return providerRepository.save(obj);
    }

    public void delete(Long id) {
        try {
            providerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Provider update(Provider obj){
        Provider newObj = findById(obj.getId());
        updateData(newObj, obj);
        return providerRepository.save(newObj);
    }

    public List<Provider> findAll(){
        return providerRepository.findAll();
    }

    private void updateData(Provider newObj, Provider obj) {
        newObj.setCode(obj.getCode());
        newObj.setName(obj.getName());
        newObj.setNif(obj.getNif());
        newObj.setAddress(obj.getAddress());
        newObj.setPhone(obj.getPhone());
        newObj.setEmail(obj.getEmail());
    }
}
