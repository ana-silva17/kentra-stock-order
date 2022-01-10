package com.kentratech.kentrastockorder.response;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class CustomResponse <T>{

    private List<T> data;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
    private boolean first;

    public CustomResponse(Page<T> page) {
        this.data = page.getContent();
        this.pageNumber = page.getPageable().getPageNumber() +1;
        this.pageSize = page.getNumberOfElements();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.last = page.isFirst();
        this.first = page.isLast();
    }
}
