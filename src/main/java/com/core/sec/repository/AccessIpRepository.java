package com.core.sec.repository;

import com.core.sec.domain.entity.AccessIp;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccessIpRepository extends JpaRepository<AccessIp, Long> {

    AccessIp findByIpAddress(String ipAddress);

}
