package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Fournisseur;
import com.testa.back.model.Produit;

public interface ProduitFournisseurService {
    
    List<Fournisseur> getAllFournisseurByProduitId(long idProduit);
    List<Fournisseur> getAllFournisseurByProduitIdAndFourni(long idProduit, boolean fourni);
    List<Fournisseur> getAllFournisseurByProduitNom(String nomProduit);
    List<Fournisseur> getAllFournisseurByProduitNomAndFourni(String nomProduit, boolean fourni);

    List<Produit> getAllProduitByFournisseurId(long idFournisseur);
    List<Produit> getAllProduitByFournisseurIdAndFourni(long idFournisseur, boolean fourni);
    List<Produit> getAllProduitByFournisseurNom(String nomFournisseur);
    List<Produit> getAllProduitByFournisseurNomAndFourni(String nomProduit, boolean fourni);

}
