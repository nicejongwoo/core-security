package com.core.sec.service.impl;

import com.core.sec.domain.dto.AccountDto;
import com.core.sec.domain.entity.Account;
import com.core.sec.domain.entity.Role;
import com.core.sec.repository.RoleRepository;
import com.core.sec.repository.UserRepository;
import com.core.sec.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void createUser(Account account) {
        Role role = roleRepository.findByRoleName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setUserRoles(roles);
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

    @Override
    public void updateUser(AccountDto accountDto) {
        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(accountDto, Account.class);

        if (accountDto.getRoles() != null) {
            Set<Role> roles = new HashSet<>();
            accountDto.getRoles().forEach(role->{
                Role findRole = roleRepository.findByRoleName(role);
                roles.add(findRole);
            });
            account.setUserRoles(roles);
        }
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        userRepository.save(account);
    }

    @Transactional
    @Override
    public void deleteUser(String username) {
        Account account = userRepository.findByUsername(username);
        account.getUserRoles().removeAll(account.getUserRoles());
        userRepository.deleteByUsername(username);
    }

    @Secured("ROLE_USER")
    @Override
    public void order() {
        System.out.println("UserService.order() - order");
    }

}
