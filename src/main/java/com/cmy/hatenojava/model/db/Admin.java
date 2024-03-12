package com.cmy.hatenojava.model.db;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.model.db
 * @className: Admin
 * @author: Terry Cai
 * @description: DB entity for admin
 * @date: 2/25/24 4:46 PM
 * @version: 1.0
 */

@Entity
@Data
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "admin_roles",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "delete_at")
    private LocalDateTime deleteAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;
}
