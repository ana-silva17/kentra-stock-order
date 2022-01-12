package com.kentratech.kentrastockorder.repository;

import com.kentratech.kentrastockorder.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderDetailRepository extends PagingAndSortingRepository<OrderDetail, Long>, JpaRepository<OrderDetail, Long> {
}
