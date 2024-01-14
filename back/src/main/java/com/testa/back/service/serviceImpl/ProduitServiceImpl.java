package com.testa.back.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.testa.back.model.Categorie;
import com.testa.back.model.Produit;
import com.testa.back.model.modelDto.ProduitDto;
import com.testa.back.repository.CategorieRepository;
import com.testa.back.repository.ProduitRepository;
import com.testa.back.service.ProduitService;

public class ProduitServiceImpl implements ProduitService{
    
    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;

    public ProduitServiceImpl(
        ProduitRepository produitRepository,
        CategorieRepository categorieRepository
        ) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Produit getProduitById(long idProduit) {
        return produitRepository.findById(idProduit).orElse(null);
    }

    @Override
    public Produit getProduitBynom(String nomProduit) {
        Produit produit = produitRepository.findByNom(nomProduit);
        if(produit == null) {
            return null;
        }
        return produit;
    }

    @Override
    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }


    @Override
    public List<Produit> getAllProduitByIdCategorie(long idCategorie) {
        Categorie categorie = categorieRepository.findById(idCategorie).orElse(null);
        if(categorie == null) {
            return new ArrayList<Produit>();
        } else {
            return produitRepository.findAllByCategorieId(idCategorie);
        }
    }

    @Override
    public List<Produit> getAllProduitByNomCategorie(String nomCategorie) {
        Categorie categorie = categorieRepository.findByNom(nomCategorie);
        if(categorie == null) {
            return new ArrayList<Produit>();
        } else {
            return produitRepository.findAllByCategorieNom(nomCategorie);
        }
    }

    @Override
    public List<Produit> getAllProduitActif() {
        return produitRepository.findAllByActif(true);
    }

    @Override
    public List<Produit> getAllProduitInactif() {
        return produitRepository.findAllByActif(false);
    }

    @Override
    public ProduitDto initProduit() {
        return new ProduitDto();
    }

    @Override
    public Produit createProduit(ProduitDto produitDto) {
        Produit produit = new Produit(produitDto);
        produit.setActif(true);
        return produitRepository.save(produit);
    }

    
    
}
