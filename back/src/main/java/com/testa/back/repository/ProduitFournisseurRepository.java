package com.testa.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testa.back.model.ProduitFournisseur;

public interface ProduitFournisseurRepository extends JpaRepository<ProduitFournisseur, Long> {
    
    List<ProduitFournisseur> findAllProduitByFournisseurId(long idFournisseur);
    List<ProduitFournisseur> findAllProduitByFournisseurIdAndFourni(long idFournisseur, boolean fourni);
    List<ProduitFournisseur> findAllProduitByFournisseurNom(String nomFournisseur);
    List<ProduitFournisseur> findAllProduitByFournisseurNomAndFourni(String nomFournisseur, boolean fourni);

    List<ProduitFournisseur> findAllFournisseurByProduitId(long idProduit);
    List<ProduitFournisseur> findAllFournisseurByProduitIdAndFourni(long idProduit, boolean fourni);
    List<ProduitFournisseur> findAllFournisseurByProduitNom(String nomProduit);
    List<ProduitFournisseur> findAllFournisseurByProduitNomAndFourni(String nomProduit, boolean fourni);

    List<ProduitFournisseur> findAllByFourni(boolean fourni);

}
