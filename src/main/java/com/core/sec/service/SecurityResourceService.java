package com.core.sec.service;

import com.core.sec.domain.entity.Resource;
import com.core.sec.repository.AccessIpRepository;
import com.core.sec.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SecurityResourceService {

    private final ResourceRepository resourceRepository;
    private final AccessIpRepository accessIpRepository;

    @Transactional(readOnly = true)
    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getResourceList() {
        LinkedHashMap<RequestMatcher, List<ConfigAttribute>> result = new LinkedHashMap<>();
        List<Resource> resourceList = resourceRepository.findAllResource();
        resourceList.forEach(resource -> {
            List<ConfigAttribute> configAttributeList = new ArrayList<>();
            resource.getRoleSet().forEach(role -> {
                configAttributeList.add(new SecurityConfig(role.getRoleName()));
            });
            result.put(new AntPathRequestMatcher(resource.getResourceName()), configAttributeList);
        });
        return result;
    }

    public List<String> getAccessIpList() {
        List<String> accessIpList = accessIpRepository.findAll()
                .stream()
                .map(accessIp -> accessIp.getIpAddress())
                .collect(Collectors.toList());
        return accessIpList;
    }

    public LinkedHashMap<String, List<ConfigAttribute>> getMethodResourceList() {
        LinkedHashMap<String, List<ConfigAttribute>> result = new LinkedHashMap<>();
        List<Resource> resourceList = resourceRepository.findAllMethodResources();
        resourceList.forEach(resource -> {
            List<ConfigAttribute> configAttributeList = new ArrayList<>();
            resource.getRoleSet().forEach(role -> {
                configAttributeList.add(new SecurityConfig(role.getRoleName()));
            });
            result.put(resource.getResourceName(), configAttributeList);
        });
        return result;
    }

    public LinkedHashMap<String, List<ConfigAttribute>> getPointcutResourceList() {
        LinkedHashMap<String, List<ConfigAttribute>> result = new LinkedHashMap<>();
        List<Resource> resourceList = resourceRepository.findAllPointcutResources();
        resourceList.forEach(resource -> {
            List<ConfigAttribute> configAttributeList = new ArrayList<>();
            resource.getRoleSet().forEach(role -> {
                configAttributeList.add(new SecurityConfig(role.getRoleName()));
            });
            result.put(resource.getResourceName(), configAttributeList);
        });
        return result;
    }
}
