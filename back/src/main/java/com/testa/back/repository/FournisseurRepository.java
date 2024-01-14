package com.testa.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testa.back.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{
    
    Fournisseur findByNom(String nom);
    
}
