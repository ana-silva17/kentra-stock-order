
package com.kentratech.kentrastockorder.repository;
import com.kentratech.kentrastockorder.entity.QuoteRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuoteRequestRepository extends PagingAndSortingRepository<QuoteRequest, Long>, JpaRepository<QuoteRequest, Long> {


}
