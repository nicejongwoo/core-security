package com.core.sec.service.impl;

import com.core.sec.domain.dto.AccountDto;
import com.core.sec.domain.entity.Account;
import com.core.sec.repository.UserRepository;
import com.core.sec.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    @Override
    public AccountDto getUser(String username) {

        Account account = userRepository.findByUsername(username);
        ModelMapper modelMapper = new ModelMapper();
        AccountDto accountDto = modelMapper.map(account, AccountDto.class);

        List<String> roles = account.getUserRoles().stream().map(userRole -> userRole.getRoleName()).collect(Collectors.toList());
        accountDto.setRoles(roles);

        return accountDto;
    }

}
