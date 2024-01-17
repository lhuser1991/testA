package com.testa.back.service;

import java.util.List;

import com.testa.back.model.generic.GenericResponse;
import com.testa.back.model.modelDto.ProduitDto;

public interface ProduitService {
    
    ProduitDto getProduitById(long idProduit);
    ProduitDto getProduitByNom(String nomProduit);

    List<ProduitDto> getAllProduit();
    List<ProduitDto> getAllProduitByIdCategorie(long idCategorie);
    List<ProduitDto> getAllProduitByNomCategorie(String nomCategorie);

    List<ProduitDto> getAllProduitActif();
    List<ProduitDto> getAllProduitActifByIdCategorie(long idCategorie);
    List<ProduitDto> getAllProduitActifByNomCategorie(String nomCategorie);
    
    ProduitDto emptyProduit();
    ProduitDto deleteProduitById(long idProduit);

    /**
     * Permet de créer ou modifier un produit.
     * Si création, doit recevoir un produitDto(nom, stock, idCategorie).
     * Si modification, doit recevoir un produitDto(id, nom, stock, actif, idCategorie, listIdFournisseur)
     */
    GenericResponse<ProduitDto> createProduit(ProduitDto produitDto);
    
}
