package com.testa.back.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testa.back.model.Produit;
import com.testa.back.model.modelDto.ProduitDto;
import com.testa.back.service.ProduitService;

@RestController
@RequestMapping("produit/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {
    
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    // ---------- GETMAPPING ---------- //

    @GetMapping("{idProduit}")
    public ResponseEntity<Produit> getProduitById(@PathVariable long idProduit) {
        return ResponseEntity.ok(produitService.getProduitById(idProduit));
    }

    @GetMapping("{nomProduit}")
    public ResponseEntity<Produit> getProduitBynom(@PathVariable String nomProduit) {
        return ResponseEntity.ok(produitService.getProduitBynom(nomProduit));
    }

    @GetMapping("list")
    public ResponseEntity<List<Produit>> getAllProduit() {
        return ResponseEntity.ok(produitService.getAllProduit());
    }

    @GetMapping("list/{idCategorie}")
    public ResponseEntity<List<Produit>> getAllProduitByIdCategorie(@PathVariable long idCategorie) {
        return ResponseEntity.ok(produitService.getAllProduitByIdCategorie(idCategorie));
    }

    @GetMapping("list/{nomCategorie}")
    public ResponseEntity<List<Produit>> getAllProduitByNomCategorie(@PathVariable String nomCategorie) {
        return ResponseEntity.ok(produitService.getAllProduitByNomCategorie(nomCategorie));
    }

    @GetMapping("list/actif")
    public ResponseEntity<List<Produit>> getAllProduitActif() {
        return ResponseEntity.ok(produitService.getAllProduitActif());
    }

    @GetMapping("list/inactif")
    public ResponseEntity<List<Produit>> getAllProduitInactif() {
        return ResponseEntity.ok(produitService.getAllProduitInactif());
    }

    @GetMapping("initProduit")
    public ResponseEntity<ProduitDto> initProduit() {
        return ResponseEntity.ok(produitService.initProduit());
    }

    // ---------- POSTMAPPING ---------- //

    @PostMapping("create")
    public ResponseEntity<Produit> createProduit(@RequestBody ProduitDto produitDto) {
        return ResponseEntity.ok(produitService.createProduit(produitDto));
    }
}