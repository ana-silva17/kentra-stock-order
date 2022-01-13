package com.kentratech.kentrastockorder.service;

import com.kentratech.kentrastockorder.entity.OrderDetail;
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
        Optional<QuoteRequestDetail> quoteRequestDetail = quoteRequestDetailRepository.findById(id);
        return quoteRequestDetail.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public QuoteRequestDetail save(QuoteRequestDetail obj) {
        obj.setId(null);
        return quoteRequestDetailRepository.save(obj);
    }
}
