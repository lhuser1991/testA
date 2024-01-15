package com.testa.back.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Categorie;
import com.testa.back.model.Fournisseur;
import com.testa.back.model.Produit;
import com.testa.back.model.ProduitFournisseur;
import com.testa.back.model.generic.GenericResponse;
import com.testa.back.model.modelDto.ProduitDto;
import com.testa.back.repository.CategorieRepository;
import com.testa.back.repository.FournisseurRepository;
import com.testa.back.repository.ProduitFournisseurRepository;
import com.testa.back.repository.ProduitRepository;
import com.testa.back.service.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService{
    
    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;
    private final FournisseurRepository fournisseurRepository;
    private final ProduitFournisseurRepository produitFournisseurRepository;

    public ProduitServiceImpl(
        ProduitRepository produitRepository,
        CategorieRepository categorieRepository,
        FournisseurRepository fournisseurRepository,
        ProduitFournisseurRepository produitFournisseurRepository
        ) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.produitFournisseurRepository = produitFournisseurRepository;
    }

    @Override
    public Produit getProduitById(long idProduit) {
        return produitRepository.findById(idProduit).orElse(null);
    }

    @Override
    public Produit getProduitByNom(String nomProduit) {
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
    public List<Produit> getAllProduitActifByIdCategorie(long idCategorie) {
        return produitRepository.findAllByActifAndCategorieId(true, idCategorie);
    }

    @Override
    public List<Produit> getAllProduitActifByNomCategorie(String nomCategorie) {
        return produitRepository.getAllByActifAndCategorieNom(true, nomCategorie);
    }

    @Override
    public ProduitDto initProduit() {
        return new ProduitDto();
    }

    @Override
    public GenericResponse<Produit> createProduit(ProduitDto produitDto) {
        Categorie categorie = categorieRepository.findById(produitDto.getIdCategorie()).orElse(null);
        String message = "";
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        for(long idFournisseur: produitDto.getListIdFournisseur()) {
            Fournisseur fournisseur = fournisseurRepository.findById(idFournisseur).orElse(null);
            if(fournisseur != null) {
                listFournisseurs.add(fournisseur);
            }
        }

        Produit produit = new Produit(produitDto);
        produit.setActif(true);

        if(categorie != null && listFournisseurs.size() == produitDto.getListIdFournisseur().size()) {
            produit.setCategorie(categorie);
            produitRepository.save(produit);
            for(Fournisseur f: listFournisseurs) {
                ProduitFournisseur produitFournisseur = new ProduitFournisseur(true, produit, f);
                produitFournisseurRepository.save(produitFournisseur);
            }
            message = "Produit ajouté.";
            return new GenericResponse<>(produit,message);
        } else {
            produit.setCategorie(new Categorie());
            message = "Erreur. Produit non ajouté";
            return new GenericResponse<>(produit, message);
        }
    }

}
