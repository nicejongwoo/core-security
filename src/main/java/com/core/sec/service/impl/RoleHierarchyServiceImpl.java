package com.core.sec.service.impl;

import com.core.sec.domain.entity.RoleHierarchy;
import com.core.sec.repository.RoleHierarchyRepository;
import com.core.sec.service.RoleHierarchyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleHierarchyServiceImpl implements RoleHierarchyService {

    @Autowired
    private RoleHierarchyRepository roleHierarchyRepository;

    @Override
    public String findAllHierarchy() {

        List<RoleHierarchy> rolesHierarchy = roleHierarchyRepository.findAll();
        StringBuilder concattedRoles = new StringBuilder();

        for (RoleHierarchy roleHierarchy : rolesHierarchy) {
            if (roleHierarchy.getParentName() != null) {
                concattedRoles.append(roleHierarchy.getParentName().getChildName());
                concattedRoles.append(" > ");
                concattedRoles.append(roleHierarchy.getChildName());
                concattedRoles.append("\n");
            }
        }

        return concattedRoles.toString();
    }
}
