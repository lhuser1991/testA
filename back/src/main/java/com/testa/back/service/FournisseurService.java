package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Fournisseur;
import com.testa.back.model.modelDto.FournisseurDto;

public interface FournisseurService {

    // --------------------------------------------------------- //
    // -------------------- FOURNISSEUR_DTO -------------------- //
    // --------------------------------------------------------- //
    
    /**
     * Permet d'obtenir un objet FournisseurDto par son id
     * @param idFournisseur L'id de l'objet FOurnisseur à obtenir
     * @return Un objet FournisseurDto si l'id du Fournisseur != 0, sinon un FournisseurDto vide
     */
    FournisseurDto getFournisseurDtoById(long idFournisseur);

    /**
     * Permet d'obtenir un objet FournisseurDto par son nom
     * @param nomFourrnisseur Le nom de l'objet FOurnisseur à obtenir
     * @return Un objet FournisseurDto l'id du Fournisseur != 0, sinon un FournisseurDto vide
     */
    FournisseurDto getFournisseurDtoByNom(String nomFourrnisseur);

    /**
     * Permet d'obtenir une liste d'objet FournisseurDto
     * @return Une liste d'objet FournisseurDto
     */
    List<FournisseurDto> getAllFournisseurDto();

    /**
     * Permet d'obtenir une liste d'objet FournisseurDto actif
     * @return Une liste d'objet FournisseurDto actif
     */
    List<FournisseurDto> getAllFournisseurDtoActif();

    /**
     * Permet d'obtenir une liste d'objet FournisseurDto à partir d'une liste d'id 
     * @param listIdFournisseur La liste d'id permettant d'obtenir la liste d'objet FournisseurDto
     * @return Une liste de FournisseurDto
     */
    List<FournisseurDto> getAllFournisseurDtoFromListFournisseurId(List<Long> listIdFournisseur);
    
    /**
     * Permet d'obtenir un FournisseurDto vide
     * @return Un FournisseurDto
     */
    FournisseurDto getEmptyFournisseurDto();

    // ----------------------------------------------------- //
    // -------------------- FOURNISSEUR -------------------- //
    // ----------------------------------------------------- //

    /**
     * Permet d'obtenir un objet Fournisseur par son id
     * @param idFournisseur L'id de l'objet Fournisseur à obtenir
     * @return Un objet Fournisseur si l'id est trouvé, sinon un Fournisseur vide
     */
    Fournisseur getFournisseurById(long idFournisseur);

    /**
     * Permet d'obtenir un objet Fournisseur par son nom
     * @param nomFourrnisseur Le nom de l'objet FOurnisseur à obtenir
     * @return Un objet Fournisseur si le nom est trouvé, sinon un Fournisseur vide
     */
    Fournisseur getFournisseurByNom(String nomFourrnisseur);

    /**
     * Permet d'obtenir une liste d'objet Fournisseur
     * @return Une liste d'objet Fournisseur
     */
    List<Fournisseur> getAllFournisseur();

    /**
     * Permet d'obtenir une liste d'objet Fournisseur actif
     * @return Une liste d'objet Fournisseur actif
     */
    List<Fournisseur> getAllFournisseurActif();

    /**
     * Permet d'obtenir une liste d'objet Fournisseur à partir d'une liste d'id 
     * @param listIdFournisseur La liste d'id permettant d'obtenir la liste d'objet Fournisseur
     * @return Une liste de Fournisseur
     */
    List<Fournisseur> getAllFournisseurFromListFournisseurId(List<Long> listIdFournisseur);

    /**
     * Permet de mettre l'etat actif à false d'un Fournisseur
     * @param idFournisseur L'id du Fournisseur que l'on veut obtenir
     * @return Un FournisseurDto
     */
    FournisseurDto deleteFournisseur(long idFournisseur);

    /**
     * Permet de creer un Fournisseur
     * @param fournisseurDto Le FournisseurDto qui servira à creer un Fournisseur
     * @return Un FournisseurDto qui possède les données du Fournisseur crée si l'id du FournisseurDto = 0, sinon un FournisseurDto vide
     */
    FournisseurDto createFournisseur(FournisseurDto fournisseurDto);

    /**
     * Permet de modifier un fournisseur existant
     * @param fournisseurDto Le FournisseurDto qui servira à modifier le Fournisseur
     * @return Un FournisseurDto qui possède les données du Fournisseur modifié sir l'id du FournisseurDto != 0, sinon un FournisseurDto vide
     */
    FournisseurDto updateFournisseur(FournisseurDto fournisseurDto);
}
