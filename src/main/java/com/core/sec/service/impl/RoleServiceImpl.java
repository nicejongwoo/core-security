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
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public RoleDto getRole(String id) {
        Role role = roleRepository.findById(Long.valueOf(id)).orElse(new Role());
        RoleDto roleDto = modelMapper.map(role, RoleDto.class);
        return roleDto;
    }

    @Override
    public void updateRole(RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        roleRepository.save(role);
    }

    @Override
    public void createRole(RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(String id) {
        Role role = roleRepository.findById(Long.valueOf(id)).orElse(new Role());
        boolean empty = role.getUsers().isEmpty();
        if (empty) {
            roleRepository.deleteById(Long.valueOf(id));
        } else {
            throw new IllegalStateException("해당 권한은 사용자가 사용중입니다.");
        }
    }
}
