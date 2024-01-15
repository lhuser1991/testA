package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Categorie;

public interface CategorieService {
    
    Categorie getCategorieById(long idCategorie);
    Categorie getCategorieBynom(String nomCategorie);
    List<Categorie> getAllCategorie();
    List<Categorie> getAllCategorieActif();
    Categorie createCategorie(Categorie categorie);
}
