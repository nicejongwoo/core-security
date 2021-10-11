package com.core.sec.service.impl;

import com.core.sec.domain.dto.RoleDto;
import com.core.sec.domain.entity.Role;
import com.core.sec.repository.RoleRepository;
import com.core.sec.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public RoleDto getRole(String id) {
        ModelMapper modelMapper = new ModelMapper();
        Role role = roleRepository.findById(Long.valueOf(id)).orElse(new Role());
        RoleDto roleDto = modelMapper.map(role, RoleDto.class);
        return roleDto;
    }
}
