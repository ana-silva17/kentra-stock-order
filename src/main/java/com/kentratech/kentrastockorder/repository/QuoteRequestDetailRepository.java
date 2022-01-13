package com.kentratech.kentrastockorder.repository;

import com.kentratech.kentrastockorder.entity.QuoteRequestDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuoteRequestDetailRepository extends PagingAndSortingRepository<QuoteRequestDetail, Long>, JpaRepository<QuoteRequestDetail, Long> {
}
