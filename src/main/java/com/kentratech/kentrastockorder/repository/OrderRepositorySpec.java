package com.kentratech.kentrastockorder.repository;

import com.kentratech.kentrastockorder.entity.Order;
import com.kentratech.kentrastockorder.service.exceptions.BadRequestException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface OrderRepositorySpec extends PagingAndSortingRepository<Order, Long>, JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

    default Optional<Order> findById(Long aLong){
        throw new BadRequestException("Order findById not allowed");
    }
    Order getById(Long id);
}
