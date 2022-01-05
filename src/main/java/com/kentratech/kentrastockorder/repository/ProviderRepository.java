package com.kentratech.kentrastockorder.repository;

import com.kentratech.kentrastockorder.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProviderRepository extends PagingAndSortingRepository<Provider, Long>, JpaRepository<Provider, Long> {
}
