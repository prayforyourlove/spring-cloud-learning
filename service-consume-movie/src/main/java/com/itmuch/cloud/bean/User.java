package com.itmuch.cloud.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable{
    private Long id;
    private String username;
    private String name;
    private Short age;
    private BigDecimal balance;
}
