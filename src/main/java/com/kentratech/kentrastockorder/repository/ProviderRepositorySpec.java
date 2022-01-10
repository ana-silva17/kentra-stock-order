package com.kentratech.kentrastockorder.repository;

import com.kentratech.kentrastockorder.entity.Provider;
import com.kentratech.kentrastockorder.service.exceptions.BadRequestException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProviderRepositorySpec extends PagingAndSortingRepository<Provider, Long>, JpaRepository<Provider, Long>, JpaSpecificationExecutor<Provider> {

    default Optional<Provider> findById(Long aLong){
        throw new BadRequestException("Provider findById not allowed");
    }
    Provider getById(Long id);
}
