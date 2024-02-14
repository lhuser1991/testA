package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Role;

public interface RoleService {
    
    /**
     * Permet d'obtenir un Role par son id
     * @param idRole L'id du Role que l'on veut obtenir
     * @return Un Role
     */
    Role getRoleById(long idRole);

    /**
     * Permet d'obtenir un Role par son nom
     * @param nomRole Le nom du Role que l'on veut obtenir
     * @return Un Role
     */
    Role getRoleByNom(String nomRole);

    /**
     * Permet d'obtenir une liste de tout les Role
     * @return Une liste de Role
     */
    List<Role> getAllRole();

    /**
     * Permet d'obtenir une liste de tout les Role actif
     * @return Une liste de Role
     */
    List<Role> getAllRoleActif();

    /**
     * Permet d'obtenir un Role vide
     * @return Un Role
     */
    Role getEmptyRole();

    /**
     * Permet de supprimer un Role
     * @param role Le Role à supprimer
     * @return Le Role supprimé
     */
    Role deleteRole(Role role);

    /**
     * Permet de créer un Role
     * @param role Le Role que l'on veut crée
     * @return Le Role crée
     */
    Role createRole(Role role);

    /**
     * Permet de modifier un Role existant
     * @param role Le Role qui contient les modifications
     * @return Le Role modifié
     */
    Role updateRole(Role role);

}
