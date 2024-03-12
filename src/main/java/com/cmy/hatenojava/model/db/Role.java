package com.cmy.hatenojava.model.db;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.model.db
 * @className: Roles
 * @author: Terry Cai
 * @description: RBAC roles entity
 * @date: 2/27/24 8:10 PM
 * @version: 1.0
 */
@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Admin> admins = new HashSet<>();
}
