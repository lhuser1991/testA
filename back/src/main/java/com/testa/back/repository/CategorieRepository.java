package com.testa.back.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.testa.back.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
    
    Categorie findByNom(String nom);
    List<Categorie> findAllByActif(boolean actif);
}
