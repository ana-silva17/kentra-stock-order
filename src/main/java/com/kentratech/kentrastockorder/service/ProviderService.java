package com.kentratech.kentrastockorder.service;

import com.kentratech.kentrastockorder.entity.Provider;
import com.kentratech.kentrastockorder.repository.ProviderRepository;
import com.kentratech.kentrastockorder.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public Provider findById(Long id){
        Optional<Provider> provider = providerRepository.findById(id);
        return provider.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Provider save(Provider obj){
        obj.setId(null);
        return providerRepository.save(obj);
    }
}
