package com.kentratech.kentrastockorder.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditOverride;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@AuditOverride(forClass = AuditModel.class)
@Table
public class QuoteRequestDetail extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quote_request_id")
    private QuoteRequest quoteRequest;

    private Long item_id;

    private String item_description;

    private Integer quantity;


}
