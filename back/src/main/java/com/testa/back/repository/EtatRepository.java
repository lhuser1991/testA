package com.testa.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testa.back.model.Etat;

public interface EtatRepository extends JpaRepository<Etat, Long>{
    
    Etat findByNom(String nomEtat);
    List<Etat> findAllByActif(boolean actif);
    
}
