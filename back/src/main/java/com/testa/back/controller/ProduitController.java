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
    public ResponseEntity<ProduitDto> getProduitById(@PathVariable long idProduit) {
        return ResponseEntity.ok(produitService.getProduitById(idProduit));
    }

    @GetMapping("nom/{nomProduit}")
    public ResponseEntity<ProduitDto> getProduitByNom(@PathVariable String nomProduit) {
        return ResponseEntity.ok(produitService.getProduitByNom(nomProduit));
    }

    @GetMapping("list")
    public ResponseEntity<List<ProduitDto>> getAllProduit() {
        return ResponseEntity.ok(produitService.getAllProduit());
    }

    @GetMapping("list/orderBy/idCategorie/{idCategorie}")
    public ResponseEntity<List<ProduitDto>> getAllProduitByIdCategorie(@PathVariable long idCategorie) {
        return ResponseEntity.ok(produitService.getAllProduitByIdCategorie(idCategorie));
    }

    @GetMapping("list/orderBy/nomCategorie/{nomCategorie}")
    public ResponseEntity<List<ProduitDto>> getAllProduitByNomCategorie(@PathVariable String nomCategorie) {
        return ResponseEntity.ok(produitService.getAllProduitByNomCategorie(nomCategorie));
    }

    @GetMapping("list/orderBy/actif")
    public ResponseEntity<List<ProduitDto>> getAllProduitActif() {
        return ResponseEntity.ok(produitService.getAllProduitActif());
    }

    @GetMapping("list/orderBy/actifAndIdCategorie/{idCategorie}")
    public ResponseEntity<List<ProduitDto>> getAllProduitActifByIdCategorie(@PathVariable long idCategorie) {
        return ResponseEntity.ok(produitService.getAllProduitActifByIdCategorie(idCategorie));
    }

    @GetMapping("list/orderBy/actifAndNomCategorie/{nomCategorie}")
    public ResponseEntity<List<ProduitDto>> getAllProduitActifByNomCategorie(@PathVariable String nomCategorie) {
        return ResponseEntity.ok(produitService.getAllProduitActifByNomCategorie(nomCategorie));
    }

    @GetMapping("emptyProduit")
    public ResponseEntity<ProduitDto> emptyProduit() {
        return ResponseEntity.ok(produitService.emptyProduit());
    }

    @GetMapping("deleteProduit/{idProduit}")
    public ResponseEntity<ProduitDto> deleteProduitById(@PathVariable long idProduit) {
        return ResponseEntity.ok(produitService.deleteProduitById(idProduit));
    }

    // ---------- POSTMAPPING ---------- //

    @PostMapping("createProduit")
    public ResponseEntity<GenericResponse<ProduitDto>> createProduit(@RequestBody ProduitDto produitDto) {
        return ResponseEntity.ok(produitService.createProduit(produitDto));
    }
}
