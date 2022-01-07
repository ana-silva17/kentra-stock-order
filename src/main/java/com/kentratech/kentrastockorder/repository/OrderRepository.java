<<<<<<< HEAD
package com.kentratech.kentrastockorder.repository;

import com.kentratech.kentrastockorder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public interface OrderRepository extends PagingAndSortingRepository<Order, Long>, JpaRepository<Order, Long> {

=======
package com.kentratech.kentrastockorder.repository;public interface OrderRepository {
>>>>>>> 37318450c99f6281312c25c6273a92eb813fc6d4
}
