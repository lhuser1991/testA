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
        if(categorie != null) {
            return categorie;
        } else {
            return new Categorie();
        }
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    @Override
    public List<Categorie> getAllCategorieActif() {
        return categorieRepository.findAllByActif(true);
    }

    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    
}
