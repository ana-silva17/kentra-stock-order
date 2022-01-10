package com.kentratech.kentrastockorder.controller;

import com.kentratech.kentrastockorder.entity.Order;
import com.kentratech.kentrastockorder.entity.QuoteRequest;
import com.kentratech.kentrastockorder.response.CustomResponse;
import com.kentratech.kentrastockorder.service.OrderService;
import com.kentratech.kentrastockorder.service.QuoteRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/quotes")
public class QuoteRequestController {

    @Autowired
    private QuoteRequestService quoteRequestService;

    @GetMapping(value = "/{id}")
    private ResponseEntity<QuoteRequest> findById(@PathVariable("id") Long id){
        QuoteRequest quoteRequest = quoteRequestService.findById(id);
        return ResponseEntity.ok().body(quoteRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        quoteRequestService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<QuoteRequest>> findAll(){
        List<QuoteRequest> list = quoteRequestService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<CustomResponse<QuoteRequest>> getQuotes(@RequestParam(name = "sort", defaultValue = "id,DESC", required = false) String order,
                                                           @RequestParam(name = "code", defaultValue = "", required = false) String code,
                                                           @RequestParam(name = "dateFrom", defaultValue = "", required = false) String dateFrom,
                                                           @RequestParam(name = "dateTo", defaultValue = "", required = false) String dateTo,
                                                           @RequestParam(name = "page", defaultValue = "1", required = false) Integer pageNumber,
                                                           @RequestParam(name = "size", defaultValue = "30", required = false) Integer pageSize) {

        String[] parseOrder = order.split(",");
        Sort sort = Sort.by(Sort.Direction.fromOptionalString(parseOrder[1]).get(), parseOrder[0]);
        Page<QuoteRequest> list = quoteRequestService.getOrders(sort, code, dateFrom, dateTo, pageNumber, pageSize);
        return ResponseEntity.ok(new CustomResponse<>(list));
    }
}
