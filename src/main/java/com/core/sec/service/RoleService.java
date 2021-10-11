package com.core.sec.service;

import com.core.sec.domain.dto.RoleDto;
import com.core.sec.domain.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();

    RoleDto getRole(String id);
}
