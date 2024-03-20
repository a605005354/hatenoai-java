package com.cmy.hatenojava.service;

import com.cmy.hatenojava.exceptions.ResponseException;
import com.cmy.hatenojava.model.db.Admin;
import com.cmy.hatenojava.model.enums.AdminErrorCode;
import com.cmy.hatenojava.model.request.AdminLoginReq;
import com.cmy.hatenojava.model.request.AdminReq;
import com.cmy.hatenojava.repository.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.service
 * @className: Adminservice
 * @author: Terry Cai
 * @description: Service for Admin
 * @date: 2/25/24 4:58 PM
 * @version: 1.0
 */
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Boolean signupAdmin(AdminReq adminReq) throws ResponseException {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminReq, admin);
        //Check Username and Email authentication
        if (adminRepository.existsByUsername(admin.getUsername())){
            throw new ResponseException(AdminErrorCode.USER_ALREADY_EXISTS.getMessage());
        }
        if (adminRepository.existsByEmail(admin.getEmail())){
            throw new ResponseException(AdminErrorCode.EMAIL_ALREADY_IN_USE.getMessage());
        }
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setCreateAt(LocalDateTime.now());
        admin.setLastLogin(LocalDateTime.now());
        //Encode password for signup
        if (adminRepository.save(admin) != null){
            return true;
        }
        return false;
    }

    public Admin loginAdmin(AdminLoginReq adminLoginReq) throws ResponseException {
        Admin admin = adminRepository.findByEmail(adminLoginReq.getEmail())
                .orElseThrow(() -> new ResponseException(AdminErrorCode.USER_DOES_NOT_EXIST.getMessage()));
        if (passwordEncoder.matches(adminLoginReq.getPassword(), admin.getPassword()) == false){
            throw new ResponseException(AdminErrorCode.PASSWORD_NOT_MATCH.getMessage());
        }
        admin.setLastLogin(LocalDateTime.now());
        adminRepository.save(admin);
        return admin;
    }

}
