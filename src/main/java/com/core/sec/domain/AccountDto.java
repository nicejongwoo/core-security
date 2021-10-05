package com.core.sec.domain;

import lombok.Data;

@Data
public class AccountDto {

    private String username;
    private String password;
    private String email;
    private Integer age;
    private String role;

}
