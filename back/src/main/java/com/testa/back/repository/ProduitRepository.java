package com.testa.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testa.back.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    
    Produit findByNom(String nom);
    List<Produit> findAllByCategorieId(long idCategorie);
    List<Produit> findAllByCategorieNom(String nomCategorie);
    List<Produit> findAllByActif(boolean actif);
    List<Produit> findAllByActifAndCategorieId(boolean actif, long idCategorie);
    List<Produit> getAllByActifAndCategorieNom(boolean actif, String nomCategorie);
}
