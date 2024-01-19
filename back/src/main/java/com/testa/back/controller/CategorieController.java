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

import com.testa.back.model.Categorie;
import com.testa.back.service.CategorieService;

@RestController
@RequestMapping("testa/categorie/")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {
    
    private final CategorieService categorieService;

    // ---------- GETMAPPING ---------- //

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("id/{idCategorie}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable long idCategorie) {
        return ResponseEntity.ok(categorieService.getCategorieById(idCategorie));
    }

    @GetMapping("nom/{nomCategorie}")
    public ResponseEntity<Categorie> getCategorieBynom(@PathVariable String nomCategorie) {
        return ResponseEntity.ok(categorieService.getCategorieBynom(nomCategorie));
    }

    @GetMapping("list")
    public ResponseEntity<List<Categorie>> getAllCategorie() {
        return ResponseEntity.ok(categorieService.getAllCategorie());
    }

    @GetMapping("list/actif")
    public ResponseEntity<List<Categorie>> getAllCategorieActif() {
        return ResponseEntity.ok(categorieService.getAllCategorieActif());
    }

    @GetMapping("emptyCategorie")
    public ResponseEntity<Categorie> getEmptyCategorie() {
        return ResponseEntity.ok(categorieService.getEmptyCategorie());
    }

    @GetMapping("deleteCategorie/{idCategorie}")
    public ResponseEntity<Categorie> deleteCategorie(@PathVariable long idCategorie) {
        return ResponseEntity.ok(categorieService.deleteCategorie(idCategorie));
    }

    // ---------- POSTMAPPING ---------- //

    @PostMapping("createCategorie")
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        return ResponseEntity.ok(categorieService.createCategorie(categorie));
    }
}
