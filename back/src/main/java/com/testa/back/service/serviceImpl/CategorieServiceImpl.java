package com.testa.back.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Categorie;
import com.testa.back.repository.CategorieRepository;
import com.testa.back.service.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService {
    
    private final CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Categorie getCategorieById(long idCategorie) {
        return categorieRepository.findById(idCategorie).orElse(null);
    }

    @Override
    public Categorie getCategorieBynom(String nomCategorie) {
        Categorie categorie = categorieRepository.findByNom(nomCategorie);
        if(categorie == null) {
            return null;
        } else {
            return categorie;
        }
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    
}
