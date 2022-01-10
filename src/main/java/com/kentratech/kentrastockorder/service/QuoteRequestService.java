package com.kentratech.kentrastockorder.service;

import com.kentratech.kentrastockorder.entity.Order;
import com.kentratech.kentrastockorder.entity.QuoteRequest;
import com.kentratech.kentrastockorder.repository.OrderRepository;
import com.kentratech.kentrastockorder.repository.OrderRepositorySpec;
import com.kentratech.kentrastockorder.repository.QuoteRequestRepository;
import com.kentratech.kentrastockorder.repository.QuoteRequestRepositorySpec;
import com.kentratech.kentrastockorder.service.exceptions.ResourceNotFoundException;
import com.kentratech.kentrastockorder.specification.OrderSpecification;
import com.kentratech.kentrastockorder.specification.QuoteRequestSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteRequestService {

    @Autowired
    private QuoteRequestRepository quoteRequestRepository;

    @Autowired
    private QuoteRequestRepositorySpec quoteRequestRepositorySpec;

    @Autowired
    private QuoteRequestSpec quoteRequestSpec;

    public QuoteRequest findById(Long id) {
        Optional<QuoteRequest> quoteRequest = quoteRequestRepository.findById(id);
        return quoteRequest.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        try {
            quoteRequestRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public List<QuoteRequest> findAll(){

        return quoteRequestRepository.findAll();
    }

    public Page<QuoteRequest> getOrders(Sort sort, String code, String dateFrom, String dateTo, Integer pageNumber, Integer pageSize) {

        Pageable p = PageRequest.of(pageNumber -1 , pageSize, sort);
        return quoteRequestRepositorySpec.findAll(Specification.where(
                this.quoteRequestSpec.findByCode(code)
                .and(this.quoteRequestSpec.findByBetweenDate(dateFrom, dateTo))),p);
    }
}
