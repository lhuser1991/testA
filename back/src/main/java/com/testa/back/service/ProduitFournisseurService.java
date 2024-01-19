package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Fournisseur;
import com.testa.back.model.Produit;
import com.testa.back.model.ProduitFournisseur;

public interface ProduitFournisseurService {
    
    List<ProduitFournisseur> getAllByProduitId(long idProduit);
    List<ProduitFournisseur> getAllByProduitNom(String nomProduit);
    List<ProduitFournisseur> getAllByFournisseurId(long idFournisseur);
    List<ProduitFournisseur> getAllByFournisseurNom(String nomFournisseur);

    List<Fournisseur> getAllFournisseurByProduitId(long idProduit);
    List<Fournisseur> getAllFournisseurByProduitNom(String nomProduit);

    List<Produit> getAllProduitByFournisseurId(long idFournisseur);
    List<Produit> getAllProduitByFournisseurNom(String nomFournisseur);

}
