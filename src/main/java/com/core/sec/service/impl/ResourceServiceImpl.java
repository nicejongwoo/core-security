package com.core.sec.service.impl;

import com.core.sec.domain.dto.ResourceDto;
import com.core.sec.domain.entity.Resource;
import com.core.sec.domain.entity.Role;
import com.core.sec.repository.ResourceRepository;
import com.core.sec.repository.RoleRepository;
import com.core.sec.service.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Resource> getResources() {
        return resourceRepository.findAll();
    }

    @Override
    public void createResource(ResourceDto resourceDto) {
        Set<Role> roleSet = new HashSet<>();
        Role role = roleRepository.findByRoleName(resourceDto.getRoleName());
        roleSet.add(role);

        Resource resource = modelMapper.map(resourceDto, Resource.class);
        resource.setRoleSet(roleSet);

        resourceRepository.save(resource);
    }

    @Override
    public ResourceDto getResource(String id) {
        Resource resource = resourceRepository.findById(Long.valueOf(id)).orElse(new Resource());
        ResourceDto resourceDto = modelMapper.map(resource, ResourceDto.class);
        return resourceDto;
    }

    @Override
    public void updateResource(ResourceDto resourceDto) {
        Set<Role> roleSet = new HashSet<>();
        Role role = roleRepository.findByRoleName(resourceDto.getRoleName());
        roleSet.add(role);

        Resource resource = modelMapper.map(resourceDto, Resource.class);
        resource.setRoleSet(roleSet);

        resourceRepository.save(resource);
    }

    @Override
    public void deleteResource(String id) {
        Resource resource = resourceRepository.findById(Long.valueOf(id)).orElse(new Resource());

        resource.getRoleSet().removeAll(resource.getRoleSet());
        resourceRepository.deleteById(Long.valueOf(id));
    }
}
