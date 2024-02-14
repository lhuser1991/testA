package com.testa.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testa.back.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
    Role findByNom(String nomRole);

    List<Role> findAllByActif(boolean actif);

}
