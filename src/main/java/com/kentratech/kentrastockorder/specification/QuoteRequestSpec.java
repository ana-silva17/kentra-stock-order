package com.kentratech.kentrastockorder.specification;

import com.kentratech.kentrastockorder.entity.Order;
import com.kentratech.kentrastockorder.entity.Order_;
import com.kentratech.kentrastockorder.entity.QuoteRequest;
import com.kentratech.kentrastockorder.service.exceptions.BadRequestException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class QuoteRequestSpec {

    public Specification<QuoteRequest> findByBetweenDate(String dateFrom, String dateTo) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        if (dateFrom.equals("") & dateTo.equals("")) {
            return (root, query, cb) -> null;
        }
        else if (dateFrom.equals("")) {
            return (root, query, cb) -> {
                try {
                    return cb.lessThanOrEqualTo(root.get(Order_.DATE), format.parse(dateTo));
                } catch (ParseException e) {
                    throw new BadRequestException("Cannot parse request dateTo " + dateTo + " . Consider send the format yyyy-MM-dd");
                }
            };
        } else if (dateTo.equals("")) {

            return (root, query, cb) -> {
                try {
                    return cb.greaterThanOrEqualTo(root.get(Order_.DATE), format.parse(dateFrom));
                } catch (ParseException e) {
                    throw new BadRequestException("Cannot parse request dateTo " + dateTo + " . Consider send the format yyyy-MM-dd");
                }
            };
        } else {
            return (root, query, cb) -> {

                Predicate greater = null;
                try {
                    greater = cb.greaterThanOrEqualTo(root.get(Order_.DATE), format.parse(dateFrom));
                } catch (ParseException e) {
                    throw new BadRequestException("Cannot parse request dateTo " + dateTo + " . Consider send the format yyyy-MM-dd");
                }
                Predicate less = null;
                try {
                    less = cb.lessThanOrEqualTo(root.get(Order_.DATE), format.parse(dateTo));
                } catch (ParseException e) {
                    throw new BadRequestException("Cannot parse request dateTo " + dateTo + " . Consider send the format yyyy-MM-dd");
                }
                return cb.and(greater, less);

            };
        }
    }
}
