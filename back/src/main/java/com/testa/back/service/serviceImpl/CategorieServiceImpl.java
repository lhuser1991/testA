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
        return categorieRepository.findById(idCategorie).orElse(getEmptyCategorie());
    }

    @Override
    public Categorie getCategorieBynom(String nomCategorie) {
        Categorie categorie = categorieRepository.findByNom(nomCategorie);
        if(categorie != null) {
            return categorie;
        } else {
            return getEmptyCategorie();
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
    public Categorie getEmptyCategorie() {
        return new Categorie();
    }

    @Override
    public Categorie deleteCategorie(long idCategorie) {
        Categorie categorie = getCategorieById(idCategorie);
        if(categorie.getId() != 0) {
            categorie.setActif(false);
            categorieRepository.save(categorie);
        }
        return categorie;
    }

    @Override
    public Categorie createCategorie(Categorie categorie) {
        Categorie newCategorie = getEmptyCategorie();
        if(categorie.getId() == 0) {
            // creation
            newCategorie = new Categorie(categorie.getNom());
        } else {
            // modification
            newCategorie = new Categorie(categorie);
        }
        return categorieRepository.save(newCategorie);
    }

    
}
