package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Operation;

public interface OperationService {

    /**
     * Retourne un objet Operation par l'id
     * @param idOperation L'id de l'objet Operation
     * @return Un objet Operation si idOperation trouvé, sinon un objet Operation vide
     */
    Operation getOperationById(long idOperation);

    /**
     * Retourne un objet Operation par le nom
     * @param nomOperation Le nom de l'objet Operation  
     * @return Un objet Operation si nomOperation trouvé, sinon un objet Operation vide
     */
    Operation getOperationByNom(String nomOperation);

    /**
     * Retourne une liste d'objet Operation
     * @return Une liste d'objet Operation
     */
    List<Operation> getAllOperation();

    /**
     * Retourne une liste d'objet Operation actif
     * @return Une liste d'objet Operation actif
     */
    List<Operation> getAllOperationActif();

    /**
     * Permet de mettre actif à false d'un objet Operation
     * @param idOperation L'id de l'objet Operation
     * @return L'objet Operation avec actif à false
     */
    Operation deleteOperation(long idOperation);

    /**
     * Permet de créer ou de modifier un objet Operation 
     * @param Operation L'objet Operation à créer ou modifier
     * @return L'objet Operation crée ou modifié
     */
    Operation createOperation(Operation Operation);

    /**
     * Peremet d'obtenir un objet Operation vide
     * @return Un objet Operation
     */
    Operation getEmptyOperation();
}
