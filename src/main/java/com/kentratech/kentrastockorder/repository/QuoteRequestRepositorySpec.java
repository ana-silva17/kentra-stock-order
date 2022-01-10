package com.kentratech.kentrastockorder.repository;

import com.kentratech.kentrastockorder.entity.Order;
import com.kentratech.kentrastockorder.entity.QuoteRequest;
import com.kentratech.kentrastockorder.service.exceptions.BadRequestException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface QuoteRequestRepositorySpec extends PagingAndSortingRepository<QuoteRequest, Long>, JpaRepository<QuoteRequest, Long>, JpaSpecificationExecutor<QuoteRequest> {

    default Optional<QuoteRequest> findById(Long aLong){
        throw new BadRequestException("Order findById not allowed");
    }
    QuoteRequest getById(Long id);
}
