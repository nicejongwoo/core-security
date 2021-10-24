package com.core.sec.service;

import com.core.sec.domain.dto.AccountDto;
import com.core.sec.domain.entity.Account;

import java.util.List;

public interface UserService {

    void createUser(Account account);

    List<Account> getUsers();

    AccountDto getUser(String username);

    void updateUser(AccountDto accountDto);

    void deleteUser(String username);

    void order();

}
