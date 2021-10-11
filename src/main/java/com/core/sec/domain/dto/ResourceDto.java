package com.core.sec.domain.dto;

import com.core.sec.domain.entity.Role;
import lombok.Data;

import java.util.Set;

@Data
public class ResourceDto {

    private String id;
    private String resourceName;
    private String httpMethod;
    private Integer orderNum;
    private String resourceType;
    private String roleName;
    private Set<Role> roleSet;

}
