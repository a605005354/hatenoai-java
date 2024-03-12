package com.cmy.hatenojava.repository;

import com.cmy.hatenojava.model.db.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
