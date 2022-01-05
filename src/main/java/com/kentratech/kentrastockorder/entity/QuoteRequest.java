package com.kentratech.kentrastockorder.entity;

import lombok.*;
import org.hibernate.envers.AuditOverride;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@AuditOverride(forClass = AuditModel.class)
@Table
public class QuoteRequest extends AuditModel{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @OneToOne
    @JoinColumn(name = "provider_id")
    @MapsId
    private Provider provider;

    @Column(name = "total_value")
    private Double totalValue;

    private Timestamp date;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "quoteRequest")
    private List<QuoteRequestDetail> quoteRequestDetailList = new ArrayList<>();


}
