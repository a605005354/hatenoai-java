package com.cmy.hatenojava;

import com.cmy.hatenojava.model.db.Admin;
import com.cmy.hatenojava.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class HatenoJavaApplicationTests {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        System.out.println("hello");
    }

    @Test
    void signup(){
        Admin admin = new Admin();
        admin.setUsername("admin");
        // Encode the password before saving
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setEmail("admin@example.com");

        // Save the admin to the database
        adminRepository.save(admin);
    }

}
