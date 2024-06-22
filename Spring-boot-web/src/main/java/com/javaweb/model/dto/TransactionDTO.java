package com.javaweb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransactionDTO extends AbstractDTO{

    private Long customerId;

    private String code;

    private String transactionDetail;
}
