package com.testa.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testa.back.model.ProduitFournisseur;

public interface ProduitFournisseurRepository extends JpaRepository<ProduitFournisseur, Long> {
    
    List<ProduitFournisseur> findAllByFournisseurId(long idFournisseur);
    List<ProduitFournisseur> findAllByFournisseurNom(String nomFournisseur);

    List<ProduitFournisseur> findAllByProduitId(long idProduit);
    List<ProduitFournisseur> findAllByProduitNom(String nomProduit);

}
