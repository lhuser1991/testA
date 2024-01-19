package com.testa.back.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testa.back.model.Categorie;
import com.testa.back.model.Produit;
import com.testa.back.service.ProduitCategorieService;

@RestController
@RequestMapping("testa/produitcategorie/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitCategorieController {
    
    private final ProduitCategorieService produitCategorieService;

    public ProduitCategorieController (ProduitCategorieService produitCategorieService) {
        this.produitCategorieService = produitCategorieService;
    }

    @GetMapping("id/{idProduit}/list/categorie")
    public ResponseEntity<List<Categorie>> getAllCategorieByProduitId(@PathVariable long idProduit) {
        return ResponseEntity.ok(produitCategorieService.getAllCategorieByProduitId(idProduit));
    }

    @GetMapping("id/{idCategorie}/list/produit")
    public ResponseEntity<List<Produit>> getAllProduitByCategorieId(@PathVariable long idCategorie) {
        return ResponseEntity.ok(produitCategorieService.getAllProduitByCategorieId(idCategorie));
    }

    @GetMapping("nom/{nomProduit}/list/categorie")
    public ResponseEntity<List<Categorie>> getAllCategorieByProduitNom(@PathVariable String nomProduit) {
        return ResponseEntity.ok(produitCategorieService.getAllCategorieByProduitNom(nomProduit));
    }

    @GetMapping("nom/{nomCategorie}/list/produit")
    public ResponseEntity<List<Produit>> getAllProduitByCategorieNom(@PathVariable String nomCategorie) {
        return ResponseEntity.ok(produitCategorieService.getAllProduitByCategorieNom(nomCategorie));
    }
}
