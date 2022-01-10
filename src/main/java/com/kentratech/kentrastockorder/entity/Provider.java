package com.kentratech.kentrastockorder.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Provider{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private Integer nif;

    private String address;

    private String phone;

    private String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "provider")
    private Order order;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "provider")
    private QuoteRequest quoteRequest;

    public Provider(Long id, String code, String name, Integer nif, String address, String phone, String email) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.nif = nif;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }




    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
