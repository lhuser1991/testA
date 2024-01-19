package com.testa.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testa.back.model.ProduitCategorie;

public interface ProduitCategorieRepository extends JpaRepository<ProduitCategorie, Long>{
    
    List<ProduitCategorie> findAllByCategorieId(long idCategorie);
    List<ProduitCategorie> findAllByCategorieNom(String nomCategorie);

    List<ProduitCategorie> findAllByProduitId(long idProduit);
    List<ProduitCategorie> findAllByProduitNom(String nomProduit);
    
}
