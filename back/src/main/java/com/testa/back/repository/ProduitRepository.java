package com.testa.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testa.back.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    
    Produit findByNom(String nom);
    List<Produit> findAllByActif(boolean actif);
    List<Produit> findAllByNumero(String numeroProduit);
}
