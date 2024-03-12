package com.cmy.hatenojava.service;

import com.cmy.hatenojava.model.db.Admin;
import com.cmy.hatenojava.repository.AdminRepository;
import com.cmy.hatenojava.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.service
 * @className: CustomUserDetailsService
 * @author: Terry Cai
 * @description: CustomUserDetailService
 * @date: 2/27/24 8:19 PM
 * @version: 1.0
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository; // Your user repository

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        Set<SimpleGrantedAuthority> grantedAuthorities = admin.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toSet());

        return new User(admin.getUsername(), admin.getPassword(), grantedAuthorities);
    }
}

