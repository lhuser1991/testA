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
import com.testa.back.model.generic.GenericResponse;
import com.testa.back.model.modelDto.ProduitDto;
import com.testa.back.service.ProduitService;

@RestController
@RequestMapping("testa/produit/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {
    
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    // ---------- GETMAPPING ---------- //

    @GetMapping("id/{idProduit}")
    public ResponseEntity<Produit> getProduitById(@PathVariable long idProduit) {
        return ResponseEntity.ok(produitService.getProduitById(idProduit));
    }

    @GetMapping("nom/{nomProduit}")
    public ResponseEntity<Produit> getProduitByNom(@PathVariable String nomProduit) {
        return ResponseEntity.ok(produitService.getProduitByNom(nomProduit));
    }

    @GetMapping("list")
    public ResponseEntity<List<Produit>> getAllProduit() {
        return ResponseEntity.ok(produitService.getAllProduit());
    }

    @GetMapping("list/orderBy/idCategorie/{idCategorie}")
    public ResponseEntity<List<Produit>> getAllProduitByIdCategorie(@PathVariable long idCategorie) {
        return ResponseEntity.ok(produitService.getAllProduitByIdCategorie(idCategorie));
    }

    @GetMapping("list/orderBy/nomCategorie/{nomCategorie}")
    public ResponseEntity<List<Produit>> getAllProduitByNomCategorie(@PathVariable String nomCategorie) {
        return ResponseEntity.ok(produitService.getAllProduitByNomCategorie(nomCategorie));
    }

    @GetMapping("list/orderBy/actif")
    public ResponseEntity<List<Produit>> getAllProduitActif() {
        return ResponseEntity.ok(produitService.getAllProduitActif());
    }

    @GetMapping("list/orderBy/actifAndIdCategorie/{idCategorie}")
    public ResponseEntity<List<Produit>> getAllProduitActifByIdCategorie(@PathVariable long idCategorie) {
        return ResponseEntity.ok(produitService.getAllProduitActifByIdCategorie(idCategorie));
    }

    @GetMapping("list/orderBy/actifAndNomCategorie/{nomCategorie}")
    public ResponseEntity<List<Produit>> getAllProduitActifByNomCategorie(@PathVariable String nomCategorie) {
        return ResponseEntity.ok(produitService.getAllProduitActifByNomCategorie(nomCategorie));
    }

    @GetMapping("initProduit")
    public ResponseEntity<ProduitDto> initProduit() {
        return ResponseEntity.ok(produitService.initProduit());
    }

    // ---------- POSTMAPPING ---------- //

    @PostMapping("create")
    public ResponseEntity<GenericResponse<Produit>> createProduit(@RequestBody ProduitDto produitDto) {
        return ResponseEntity.ok(produitService.createProduit(produitDto));
    }
}
