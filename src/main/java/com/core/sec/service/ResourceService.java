package com.core.sec.service;

import com.core.sec.domain.dto.ResourceDto;
import com.core.sec.domain.entity.Resource;

import java.util.List;

public interface ResourceService {
    List<Resource> getResources();

    void createResource(ResourceDto resourceDto);

    ResourceDto getResource(String id);

    void updateResource(ResourceDto resourceDto);

    void deleteResource(String id);
}
