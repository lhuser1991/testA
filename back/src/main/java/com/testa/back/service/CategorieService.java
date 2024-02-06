package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Categorie;

public interface CategorieService {
    
    /**
     * Permet d'obtenir un objet Categorie
     * @param idCategorie L'id de l'objet Categorie à obtenir
     * @return Un objet Categorie si l'id est trouvé, sinon un objet Categorie vide
     */
    Categorie getCategorieById(long idCategorie);

    /**
     * Permet d'obtenir un objet Categorie
     * @param nomCategorie Le nom de l'objet Categorie à obtenir
     * @return Un objet Categorie si l'id est trouvé, sinon un objet Categorie vide
     */
    Categorie getCategorieBynom(String nomCategorie);

    /**
     * Permet d'obtenir une liste de tout les objets Categorie
     * @return Une liste d'objet Categorie
     */
    List<Categorie> getAllCategorie();

    /**
     * Permet d'obtenir une liste de tout les objets Categorie actif 
     * @return Une liste d'objet Categorie
     */
    List<Categorie> getAllCategorieActif();

    /**
     * Permet d'obtenir un objet Categorie vide
     * @return Un objet Categorie
     */
    Categorie getEmptyCategorie();

    /**
     * 
     * @param categorie
     * @return
     */
    Categorie createCategorie(Categorie categorie);

    /**
     * Peremt de mettre l'attribut actif d'un Objet Categorie à false
     * @param idCategorie L'id de l'objet Categorie à obtenir
     * @return L'objet Categorie avec actif à false
     */
    Categorie deleteCategorie(long idCategorie);
}
