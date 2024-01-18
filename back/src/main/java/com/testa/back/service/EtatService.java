package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Etat;

public interface EtatService {

    /**
     * Retourne un objet Etat par l'id
     * @param idEtat L'id de l'objet Etat
     * @return Un objet Etat si idEtat trouvé, sinon un objet Etat vide
     */
    Etat getEtatById(long idEtat);

    /**
     * Retourne un objet Etat par le nom
     * @param nomEtat Le nom de l'objet Etat  
     * @return Un objet Etat si nomEtat trouvé, sinon un objet Etat vide
     */
    Etat getEtatByNom(String nomEtat);

    /**
     * Retourne une liste d'objet Etat
     * @return Une liste d'objet Etat
     */
    List<Etat> getAllEtat();

    /**
     * Retourne une liste d'objet Etat actif
     * @return Une liste d'objet Etat actif
     */
    List<Etat> getAllEtatActif();

    /**
     * Permet de mettre actif à false d'un objet Etat
     * @param idEtat L'id de l'objet Etat
     * @return L'objet Etat avec actif à false
     */
    Etat deleteEtat(long idEtat);

    /**
     * Permet de créer ou de modifier un objet Etat 
     * @param etat L'objet Etat à créer ou modifier
     * @return L'objet Etat crée ou modifié
     */
    Etat createEtat(Etat etat);
}
