package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Produit;
import com.testa.back.model.modelDto.ProduitDto;

public interface ProduitService {
    
    Produit getProduitById(long idProduit);
    Produit getProduitBynom(String nomProduit);

    List<Produit> getAllProduit();
    List<Produit> getAllProduitByIdCategorie(long idCategorie);
    List<Produit> getAllProduitByNomCategorie(String nomCategorie);

    List<Produit> getAllProduitActif();
    List<Produit> getAllProduitInactif();
    ProduitDto initProduit();
    Produit createProduit(ProduitDto produitDto);
}
