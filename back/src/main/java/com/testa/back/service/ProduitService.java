package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Produit;
import com.testa.back.model.generic.GenericResponse;
import com.testa.back.model.modelDto.ProduitDto;

public interface ProduitService {
    

    /**
     * Permet d'obtenir un Produit par son id
     * @param idProduit L'id du Produit que l'on veut obtenir
     * @return Un Produit non vide si id trouvé, sinon un Produit vide
     */
    Produit getProduiById(long idProduit);
    
    /**
     * Permet d'obtenir un Produit par son nom
     * @param nomProduit Le nom du Produit que l'on veut obtenir
     * @return Un Produit non vide si nom trouvé, sinon un Produit vide
     */
    Produit getProduitByNom(String nomProduit);

    /**
     * Permet d'obtenir une liste de Produit 
     * @return Une liste de Produit
     */
    List<Produit> getAllProduit();

    /**
     * Permet d'obtenir une liste de Produit actif
     * @return Une liste de Produit actif
     */
    List<Produit> getAllProduitActif();

    /**
     * Permet d'obtenir un ProduitDto vide
     * @return Un ProduitDto vide
     */
    Produit getEmptyProduit();

    /**
     * Permet de mettre actif à false à un Produit par son id
     * @param idProduit L'id du produit où on veut mettre actif à false
     * @return Le Produit avec actif à false, sinon un Produit vide
     */
    Produit deleteProduitById(long idProduit);

    /**
     * Permet de récuperer une liste de Produit possèdant le meme numeroProduit
     * @param numeroProduit Le numero du Produit à chercher
     * @return Une liste de Produit
     */
    List<Produit> getAllProduitByNumeroProduit(String numeroProduit);
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Permet d'obtenir un ProduitDto par l'id du Produit
     * @param idProduit L'id du Produit que l'on veut obtenir
     * @return Un ProduitDto non vide si id du Produit trouvé, sinon un ProduitDto vide
     */
    ProduitDto getProduitDtoById(long idProduit);
    
    /**
     * Permet d'obtenir un ProduitDto par le nom du Produit
     * @param nomProduit Le nom du Produit que l'on veut obtenir
     * @return Un ProduitDto non vide si nom du Produit trouvé, sinon un ProduitDto vide
     */
    ProduitDto getProduitDtoByNom(String nomProduit);

    /**
     * Permet d'obtenir une liste de ProduitDto
     * @return Une liste de ProduitDto
     */
    List<ProduitDto> getAllProduitDto();

    /**
     * Permet d'obtenir une liste de ProduitDto actif
     * @return Une liste de ProduitDto actif
     */
    List<ProduitDto> getAllProduiDtotActif();
    
    /**
     * Permet d'obtenir un ProduitDto vide
     * @return Un ProduitDto vide
     */
    ProduitDto getEmptyProduitDto();

    /**
     * Permet de mettre actif à false à un Produit par son id
     * @param idProduit L'id du produit où on veut mettre actif à false
     * @return Le ProduitDto avec actif à false, sinon un ProduitDto vide
     */
    ProduitDto deleteProduitDtoById(long idProduit);

    /**
     * Permet de récuperer une liste de ProduitDto possèdant le meme numeroProduit
     * @param numeroProduit Le numero du Produit à chercher
     * @return Une liste de ProduitDto
     */
    List<ProduitDto> getAllProduitDtoByNumeroProduit(String numeroProduit);

    GenericResponse<ProduitDto> createProduit(ProduitDto produitDto);

    GenericResponse<ProduitDto> updateProduit(ProduitDto produitDto);
    
}
