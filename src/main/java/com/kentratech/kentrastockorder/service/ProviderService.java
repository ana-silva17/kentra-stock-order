package com.kentratech.kentrastockorder.service;

import com.kentratech.kentrastockorder.entity.Provider;
import com.kentratech.kentrastockorder.repository.ProviderRepository;
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

    public Provider findById(Long id) {
        Optional<Provider> provider = providerRepository.findById(id);
        return provider.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Provider save(Provider obj) {
        obj.setId(null);
        return providerRepository.save(obj);
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
