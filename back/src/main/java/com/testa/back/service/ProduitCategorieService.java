package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Categorie;
import com.testa.back.model.Produit;
import com.testa.back.model.ProduitCategorie;

public interface ProduitCategorieService {
    
    List<ProduitCategorie> getAllByProduitId(long idProduit);
    List<Categorie> getAllCategorieByProduitId(long idProduit);

    List<ProduitCategorie> getAllByProduitNom(String nomProduit);
    List<Categorie> getAllCategorieByProduitNom(String nomProduit);
    
    List<ProduitCategorie> getAllByCategorieId(long idCategorie);
    List<Produit> getAllProduitByCategorieId(long idCategorie);

    List<ProduitCategorie> getAllByCategorieNom(String nomCategorie);
    List<Produit> getAllProduitByCategorieNom(String nomCategorie);

}
