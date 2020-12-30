package org.cc.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Account implements Serializable {
    private static final long serialVersionUID = -3535533038983779232L;

    private Long accountId;

    private Integer currency;

    private Long balance;

    private Long userid;
}