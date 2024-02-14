package com.testa.back.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Role;
import com.testa.back.repository.RoleRepository;
import com.testa.back.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(
        RoleRepository roleRepository
    ) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleById(long idRole) {
        Role role = roleRepository.findById(idRole).orElse(null);
        if(role != null) {
            return role;
        } else {
            return new Role();
        }
    }

    @Override
    public Role getRoleByNom(String nomRole) {
        Role role = roleRepository.findByNom(nomRole);
        if(role != null) {
            return role;
        } else {
            return new Role();
        }
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> getAllRoleActif() {
        return roleRepository.findAllByActif(true);
    }

    @Override
    public Role getEmptyRole() {
        return new Role();
    }

    @Override
    public Role deleteRole(Role role) {
        if(role.getId() != 0) {
            role.setActif(false);
            return role;
        } else {
            return getEmptyRole();
        }
    }

    @Override
    public Role createRole(Role role) {
        role.setActif(true);
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        if(role.getId() != 0) {
            return roleRepository.save(role);
        } else {
            return new Role();
        }
    }
    
}
