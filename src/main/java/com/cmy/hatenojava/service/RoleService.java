package com.cmy.hatenojava.service;

import com.cmy.hatenojava.repository.AdminRepository;
import com.cmy.hatenojava.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.service
 * @className: RoleService
 * @author: Terry Cai
 * @description: Service for role
 * @date: 2/27/24 8:14 PM
 * @version: 1.0
 */
@Service
public class RoleService {

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final AdminRepository adminRepository;

    public RoleService(RoleRepository roleRepository, AdminRepository adminRepository) {
        this.roleRepository = roleRepository;
        this.adminRepository = adminRepository;
    }

}
