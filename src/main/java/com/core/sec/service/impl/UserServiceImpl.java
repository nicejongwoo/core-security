package com.core.sec.service.impl;

import com.core.sec.domain.Account;
import com.core.sec.repository.UserRepository;
import com.core.sec.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public void createUser(Account account) {
        userRepository.save(account);
    }

    @Override
    public List<Account> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Account getUser(String username) {
        return userRepository.findByUsername(username);
    }

}
