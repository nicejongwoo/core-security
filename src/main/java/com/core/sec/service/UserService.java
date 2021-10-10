package com.core.sec.service;

import com.core.sec.domain.Account;

import java.util.List;

public interface UserService {

    void createUser(Account account);

    List<Account> getUsers();

    Account getUser(String username);
}
