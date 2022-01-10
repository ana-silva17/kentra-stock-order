package com.kentratech.kentrastockorder.specification;

import com.kentratech.kentrastockorder.entity.Provider;
import com.kentratech.kentrastockorder.entity.Provider_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProviderSpecification {

    public Specification<Provider> findByCode(String code) {
        if (code == null) {
            return null;
        }
        return (root, query, cb) -> cb.like(root.get(Provider_.CODE), "%" + code + "%");

    }

    public Specification<Provider> findByName(String name) {
        if (name == null) {
            return null;
        }
        return (root, query, cb) -> cb.like(root.get(Provider_.NAME), "%" + name + "%");

    }

}
