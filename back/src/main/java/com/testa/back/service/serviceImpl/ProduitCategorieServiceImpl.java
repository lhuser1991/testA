package com.testa.back.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Categorie;
import com.testa.back.model.Produit;
import com.testa.back.model.ProduitCategorie;
import com.testa.back.repository.ProduitCategorieRepository;
import com.testa.back.service.ProduitCategorieService;

@Service
public class ProduitCategorieServiceImpl implements ProduitCategorieService{

    private final ProduitCategorieRepository produitCategorieRepository;

    public ProduitCategorieServiceImpl(ProduitCategorieRepository produitCategorieRepository) {
        this.produitCategorieRepository = produitCategorieRepository;
    }

    @Override
    public List<ProduitCategorie> getAllByProduitId(long idProduit) {
        return produitCategorieRepository.findAllByProduitId(idProduit);
    }

    @Override
    public List<ProduitCategorie> getAllByProduitNom(String nomProduit) {
        return produitCategorieRepository.findAllByProduitNom(nomProduit);
    }
    
    @Override
    public List<ProduitCategorie> getAllByCategorieId(long idCategorie) {
        return produitCategorieRepository.findAllByCategorieId(idCategorie);
    }

    @Override
    public List<ProduitCategorie> getAllByCategorieNom(String nomCategorie) {
        return produitCategorieRepository.findAllByCategorieNom(nomCategorie);
    }

    @Override
    public List<Categorie> getAllCategorieByProduitId(long idProduit) {
        List<ProduitCategorie> listProduitCategorie = getAllByCategorieId(idProduit);
        List<Categorie> listCategorie = new ArrayList<Categorie>();
        for(ProduitCategorie pc: listProduitCategorie) {
            listCategorie.add(pc.getCategorie());
        }
        return listCategorie;
    }

    @Override
    public List<Categorie> getAllCategorieByProduitNom(String nomProduit) {
        List<ProduitCategorie> listProduitCategorie = getAllByProduitNom(nomProduit);
        List<Categorie> listCategorie = new ArrayList<Categorie>();
        for(ProduitCategorie pc: listProduitCategorie) {
            listCategorie.add(pc.getCategorie());
        }
        return listCategorie;
    }

    @Override
    public List<Produit> getAllProduitByCategorieId(long idCategorie) {
        List<ProduitCategorie> listProduitCategorie = getAllByCategorieId(idCategorie);
        List<Produit> listProduit = new ArrayList<Produit>();
        for(ProduitCategorie pc: listProduitCategorie) {
            listProduit.add(pc.getProduit());
        }
        return listProduit;
    }

    @Override
    public List<Produit> getAllProduitByCategorieNom(String nomCategorie) {
        List<ProduitCategorie> listProduitCategorie = getAllByCategorieNom(nomCategorie);
        List<Produit> listProduit = new ArrayList<Produit>();
        for(ProduitCategorie pc: listProduitCategorie) {
            listProduit.add(pc.getProduit());
        }
        return listProduit;
    }
    
}
