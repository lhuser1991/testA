package com.testa.back.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Fournisseur;
import com.testa.back.model.Produit;
import com.testa.back.model.ProduitFournisseur;
import com.testa.back.repository.ProduitFournisseurRepository;
import com.testa.back.service.ProduitFournisseurService;

@Service
public class ProduitFournisseurServiceImpl implements ProduitFournisseurService{

    private final ProduitFournisseurRepository produitFournisseurRepository;

    public ProduitFournisseurServiceImpl(
        ProduitFournisseurRepository produitFournisseurRepository

        ) {
        this.produitFournisseurRepository = produitFournisseurRepository;
    }

    @Override
    public List<Fournisseur> getAllFournisseurByProduitId(long idProduit) {
        List<ProduitFournisseur> listProduitFournisseurs = produitFournisseurRepository.findAllFournisseurByProduitId(idProduit);
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        for(ProduitFournisseur pf: listProduitFournisseurs) {
            listFournisseurs.add(pf.getFournisseur());
        }
        return listFournisseurs;
    }

    @Override
    public List<Fournisseur> getAllFournisseurByProduitNom(String nomProduit) {
        List<ProduitFournisseur> listProduitFournisseurs = produitFournisseurRepository.findAllFournisseurByProduitNom(nomProduit);
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        for(ProduitFournisseur pf: listProduitFournisseurs) {
            listFournisseurs.add(pf.getFournisseur());
        }
        return listFournisseurs;
    }
    
    @Override
    public List<Fournisseur> getAllFournisseurByProduitIdAndFourni(long idProduit, boolean fourni) {
        List<ProduitFournisseur> listProduitFournisseurs = produitFournisseurRepository.findAllFournisseurByProduitIdAndFourni(idProduit, fourni);
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        for(ProduitFournisseur pf: listProduitFournisseurs) {
            listFournisseurs.add(pf.getFournisseur());
        }
        return listFournisseurs;
    }

    @Override
    public List<Fournisseur> getAllFournisseurByProduitNomAndFourni(String nomProduit, boolean fourni) {
        List<ProduitFournisseur> listProduitFournisseurs = produitFournisseurRepository.findAllFournisseurByProduitNomAndFourni(nomProduit, fourni);
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        for(ProduitFournisseur pf: listProduitFournisseurs) {
            listFournisseurs.add(pf.getFournisseur());
        }
        return listFournisseurs;
    }

    @Override
    public List<Produit> getAllProduitByFournisseurId(long idFournisseur) {
        List<ProduitFournisseur> listProduitFournisseurs = produitFournisseurRepository.findAllProduitByFournisseurId(idFournisseur);
        List<Produit> listProduit = new ArrayList<Produit>();
        for(ProduitFournisseur pf: listProduitFournisseurs) {
            listProduit.add(pf.getProduit());
        }
        return listProduit;
    }

    @Override
    public List<Produit> getAllProduitByFournisseurNom(String nomFournisseur) {
        List<ProduitFournisseur> listProduitFournisseurs = produitFournisseurRepository.findAllProduitByFournisseurNom(nomFournisseur);
        List<Produit> listProduit = new ArrayList<Produit>();
        for(ProduitFournisseur pf: listProduitFournisseurs) {
            listProduit.add(pf.getProduit());
        }
        return listProduit;
    }

    @Override
    public List<Produit> getAllProduitByFournisseurIdAndFourni(long idFournisseur, boolean fourni) {
        List<ProduitFournisseur> listProduitFournisseurs = produitFournisseurRepository.findAllProduitByFournisseurIdAndFourni(idFournisseur, fourni);
        List<Produit> listProduit = new ArrayList<Produit>();
        for(ProduitFournisseur pf: listProduitFournisseurs) {
            listProduit.add(pf.getProduit());
        }
        return listProduit;
    }

    @Override
    public List<Produit> getAllProduitByFournisseurNomAndFourni(String nomProduit, boolean fourni) {
        List<ProduitFournisseur> listProduitFournisseurs = produitFournisseurRepository.findAllProduitByFournisseurNomAndFourni(nomProduit, fourni);
        List<Produit> listProduit = new ArrayList<Produit>();
        for(ProduitFournisseur pf: listProduitFournisseurs) {
            listProduit.add(pf.getProduit());
        }
        return listProduit;
    }
    
}
