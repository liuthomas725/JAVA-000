package org.cc.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Freeze implements Serializable {
    private static final long serialVersionUID = -4762558834729163186L;

    private Long freezeId;

    private Long freezeAmount;

    private Integer freezeStatus;

    private Long accountId;
}
