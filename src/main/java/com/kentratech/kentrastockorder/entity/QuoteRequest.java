package com.kentratech.kentrastockorder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.envers.AuditOverride;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@AuditOverride(forClass = AuditModel.class)
@Table
public class QuoteRequest extends AuditModel{

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Transient
    Date now = new Date();

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Transient
    Timestamp timestamp = new Timestamp(now.getTime());

    @Id
    private Long id;

    private String code;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "provider_id")
    @MapsId
    private Provider provider;

    @Column(name = "total_value")
    private Double totalValue;

    private Timestamp date = timestamp;

    @JsonIgnore
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "quoteRequest")
    private List<QuoteRequestDetail> quoteRequestDetailList = new ArrayList<>();

    public QuoteRequest(Long id, String code, Provider provider, Double totalValue, Timestamp date) {
        this.id = id;
        this.code = code;
        this.provider = provider;
        this.totalValue = totalValue;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuoteRequest)) return false;
        QuoteRequest that = (QuoteRequest) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
