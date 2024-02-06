package com.testa.back.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testa.back.model.Fournisseur;
import com.testa.back.model.Produit;
import com.testa.back.service.ProduitFournisseurService;

@RestController
@RequestMapping("testa/produitfournisseur/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitFournisseurController {
    
    private final ProduitFournisseurService produitFournisseurService;

    public ProduitFournisseurController(ProduitFournisseurService produitFournisseurService) {
        this.produitFournisseurService = produitFournisseurService;
    }

    // ---------- GETMAPPING ---------- //

    @GetMapping("id/{idProduit}/list/fournisseur")
    public ResponseEntity<List<Fournisseur>> getAllFournisseurByProduitId(@PathVariable long idProduit) {
        return ResponseEntity.ok(produitFournisseurService.getAllFournisseurByProduitId(idProduit));
    }

    @GetMapping("id/{idFournisseur}/list/produit")
    public ResponseEntity<List<Produit>> getAllProduitByFournisseurId(@PathVariable long idFournisseur) {
        return ResponseEntity.ok(produitFournisseurService.getAllProduitByFournisseurId(idFournisseur));
    }

    @GetMapping("nom/{nomProduit}/list/fournisseur")
    public ResponseEntity<List<Fournisseur>> getAllFournisseurByProduitNom(@PathVariable String nomProduit) {
        return ResponseEntity.ok(produitFournisseurService.getAllFournisseurByProduitNom(nomProduit));
    }

    @GetMapping("nom/{nomFournisseur}/list/produit")
    public ResponseEntity<List<Produit>> getAllProduitByFournisseurNom(@PathVariable String nomFournisseur) {
        return ResponseEntity.ok(produitFournisseurService.getAllProduitByFournisseurNom(nomFournisseur));
    }

    // ---------- POSTMAPPING ---------- //


}
