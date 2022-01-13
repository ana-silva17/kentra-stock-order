package com.kentratech.kentrastockorder.service;

import com.kentratech.kentrastockorder.entity.QuoteRequestDetail;
import com.kentratech.kentrastockorder.repository.QuoteRequestDetailRepository;
import com.kentratech.kentrastockorder.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuoteRequestDetailService {

    @Autowired
    private QuoteRequestDetailRepository quoteRequestDetailRepository;

    public QuoteRequestDetail findById(Long id) {
        Optional<QuoteRequestDetail> orderDetail = quoteRequestDetailRepository.findById(id);
        return orderDetail.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
