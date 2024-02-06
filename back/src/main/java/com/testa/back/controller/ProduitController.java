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
        return ResponseEntity.ok(produitService.getProduitDtoById(idProduit));
    }

    @GetMapping("nom/{nomProduit}")
    public ResponseEntity<ProduitDto> getProduitByNom(@PathVariable String nomProduit) {
        return ResponseEntity.ok(produitService.getProduitDtoByNom(nomProduit));
    }

    @GetMapping("list")
    public ResponseEntity<List<ProduitDto>> getAllProduit() {
        return ResponseEntity.ok(produitService.getAllProduitDto());
    }

    @GetMapping("list/orderBy/actif")
    public ResponseEntity<List<ProduitDto>> getAllProduitActif() {
        return ResponseEntity.ok(produitService.getAllProduiDtotActif());
    }

    @GetMapping("emptyProduit")
    public ResponseEntity<ProduitDto> emptyProduit() {
        return ResponseEntity.ok(produitService.getEmptyProduitDto());
    }

    @GetMapping("deleteProduit/{idProduit}")
    public ResponseEntity<ProduitDto> deleteProduitById(@PathVariable long idProduit) {
        return ResponseEntity.ok(produitService.deleteProduitDtoById(idProduit));
    }

    @GetMapping("list/{numeroProduit}")
    public ResponseEntity<List<ProduitDto>> getAllByNumeroProduit(@PathVariable String numeroProduit) {
        return ResponseEntity.ok(produitService.getAllProduitDtoByNumeroProduit(numeroProduit));
    }

    // ---------- POSTMAPPING ---------- //

    @PostMapping("createProduit")
    public ResponseEntity<GenericResponse<ProduitDto>> createProduit(@RequestBody ProduitDto produitDto) {
        return ResponseEntity.ok(produitService.createProduit(produitDto));
    }

    @PostMapping("updateProduit")
    public ResponseEntity<GenericResponse<ProduitDto>> updateProduit(@RequestBody ProduitDto produitDto) {
        return ResponseEntity.ok(produitService.updateProduit(produitDto));
    }
}
