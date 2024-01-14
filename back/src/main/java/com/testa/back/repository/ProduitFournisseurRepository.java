package com.testa.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testa.back.model.Fournisseur;
import com.testa.back.model.Produit;
import com.testa.back.model.ProduitFournisseur;

public interface ProduitFournisseurRepository extends JpaRepository<ProduitFournisseur, Long> {
    
    List<Produit> findAllProduitByFournisseurId(long idFournisseur);
    List<Produit> findAllProduitByFournisseurIdAndEstFourni(long idFournisseur, boolean estFourni);
    List<Produit> findAllProduitByFournisseurNom(String nomFournisseur);
    List<Produit> findAllProduitByFournisseurNomAndEstFourni(String nomFournisseur, boolean estFourni);

    List<Fournisseur> findAllFournisseurByProduitId(long idProduit);
    List<Fournisseur> findAllFournisseurByProduitIdAndEstFourni(long idProduit, boolean estFourni);
    List<Fournisseur> findAllFournisseurByProduitNom(String nomProduit);
    List<Fournisseur> findAllFournisseurByProduitNomAndEstFourni(String nomProduit, boolean estFourni);
    
    List<ProduitFournisseur> findAllByEstFourni(boolean estFourni);

}
