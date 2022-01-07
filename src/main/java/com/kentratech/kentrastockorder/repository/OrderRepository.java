
package com.kentratech.kentrastockorder.repository;

import com.kentratech.kentrastockorder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public interface OrderRepository extends PagingAndSortingRepository<Order, Long>, JpaRepository<Order, Long>{

}
