package com.javaweb.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "note")
    private String note;

    @Column(name = "createddate")
    private Date createdDate;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "modifieddate")
    private Date modifiedDate;

    @Column(name = "modifiedby")
    private String modifiedBy;

    @Column(name = "staffid")
    private Long staffId;


    @ManyToOne
    @JoinColumn(name="customerid", nullable=false)
    private CustomerEntity customer;

}
