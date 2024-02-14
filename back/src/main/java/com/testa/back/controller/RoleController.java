package com.testa.back.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testa.back.model.Role;
import com.testa.back.service.RoleService;

@RestController
@RequestMapping("testa/role/")
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {
    
    private final RoleService roleService;

    public RoleController(
        RoleService roleService
    ) {
        this.roleService = roleService;
    }

    // ---------- GETMAPPING ---------- //

    @GetMapping("id/{idRole}")
    public ResponseEntity<Role> getRoleById(@PathVariable long idRole) {
        return ResponseEntity.ok(roleService.getRoleById(idRole));
    }

    @GetMapping("nom/{nomRole}")
    public ResponseEntity<Role> getRoleByNom(@PathVariable String nomRole) {
        return ResponseEntity.ok(roleService.getRoleByNom(nomRole));
    }

    @GetMapping("list")
    public ResponseEntity<List<Role>> getAllRole() {
        return ResponseEntity.ok(roleService.getAllRole());
    }    

    @GetMapping("list/actif")
    public ResponseEntity<List<Role>> getAllRoleActif() {
        return ResponseEntity.ok(roleService.getAllRoleActif());
    }

    @GetMapping("emptyRole")
    public ResponseEntity<Role> emptyRole() {
        return ResponseEntity.ok(roleService.getEmptyRole());
    }
    
    @GetMapping("delete")
    public ResponseEntity<Role> deleteRole(Role role) {
        return ResponseEntity.ok(roleService.deleteRole(role));
    }

    // ---------- POSTMAPPING ---------- //

    @PostMapping("createRole")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.createRole(role));
    }

    @PostMapping("updateRole")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.updateRole(role));
    }

}
