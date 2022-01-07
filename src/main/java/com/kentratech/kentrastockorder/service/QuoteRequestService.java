package com.kentratech.kentrastockorder.service;

import com.kentratech.kentrastockorder.entity.Order;
import com.kentratech.kentrastockorder.entity.QuoteRequest;
import com.kentratech.kentrastockorder.repository.OrderRepository;
import com.kentratech.kentrastockorder.repository.QuoteRequestRepository;
import com.kentratech.kentrastockorder.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuoteRequestService {

    @Autowired
    private QuoteRequestRepository quoteRequestRepository;

    public QuoteRequest findById(Long id) {
        Optional<QuoteRequest> quoteRequest = quoteRequestRepository.findById(id);
        return quoteRequest.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
