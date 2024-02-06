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
    public List<ProduitFournisseur> getAllByProduitId(long idProduit) {
        return produitFournisseurRepository.findAllByProduitId(idProduit);
    }

    @Override
    public List<ProduitFournisseur> getAllByProduitNom(String nomProduit) {
        return produitFournisseurRepository.findAllByProduitNom(nomProduit);
    }

    @Override
    public List<ProduitFournisseur> getAllByFournisseurId(long idFournisseur) {
        return produitFournisseurRepository.findAllByFournisseurId(idFournisseur);
    }

    @Override
    public List<ProduitFournisseur> getAllByFournisseurNom(String nomFournisseur) {
        return produitFournisseurRepository.findAllByFournisseurNom(nomFournisseur);
    }

    @Override
    public List<Fournisseur> getAllFournisseurByProduitId(long idProduit) {
        List<ProduitFournisseur> listProduitFournisseurs = getAllByProduitId(idProduit);
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        for(ProduitFournisseur pf: listProduitFournisseurs) {
            listFournisseurs.add(pf.getFournisseur());
        }
        return listFournisseurs;
    }

    @Override
    public List<Fournisseur> getAllFournisseurByProduitNom(String nomProduit) {
        List<ProduitFournisseur> listProduitFournisseurs = getAllByProduitNom(nomProduit);
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        for(ProduitFournisseur pf: listProduitFournisseurs) {
            listFournisseurs.add(pf.getFournisseur());
        }
        return listFournisseurs;
    }

    @Override
    public List<Produit> getAllProduitByFournisseurId(long idFournisseur) {
        List<ProduitFournisseur> listProduitFournisseurs = getAllByFournisseurId(idFournisseur);
        List<Produit> listProduit = new ArrayList<Produit>();
        for(ProduitFournisseur pf: listProduitFournisseurs) {
            listProduit.add(pf.getProduit());
        }
        return listProduit;
    }

    @Override
    public List<Produit> getAllProduitByFournisseurNom(String nomFournisseur) {
        List<ProduitFournisseur> listProduitFournisseurs = getAllByFournisseurNom(nomFournisseur);
        List<Produit> listProduit = new ArrayList<Produit>();
        for(ProduitFournisseur pf: listProduitFournisseurs) {
            listProduit.add(pf.getProduit());
        }
        return listProduit;
    }
    
}
