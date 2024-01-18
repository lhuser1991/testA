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

import com.testa.back.model.modelDto.FournisseurDto;
import com.testa.back.service.FournisseurService;

@RestController
@RequestMapping("testa/fournisseur/")
@CrossOrigin(origins = "http://localhost:4200")
public class FournisseurController {
    
    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    // ---------- GETMAPPING ---------- //

    @GetMapping("id/{idFournisseur}")
    public ResponseEntity<FournisseurDto> getFournisseurById(@PathVariable long idFournisseur) {
        return ResponseEntity.ok(fournisseurService.getFournisseurById(idFournisseur));
    }

    @GetMapping("nom/{nomFournisseur}")
    public ResponseEntity<FournisseurDto> getFournisseurBynom(@PathVariable String nomFournisseur) {
        return ResponseEntity.ok(fournisseurService.getFournisseurByNom(nomFournisseur));
    }

    @GetMapping("list")
    public ResponseEntity<List<FournisseurDto>> getAllFournisseur() {
        return ResponseEntity.ok(fournisseurService.getAllFournisseur());
    }

    @GetMapping("list/actif")
    public ResponseEntity<List<FournisseurDto>> getAllFournisseurActif() {
        return ResponseEntity.ok(fournisseurService.getAllFournisseurActif());
    }

    @GetMapping("emptyFournisseur")
    public ResponseEntity<FournisseurDto> getEmptyFournisseur() {
        return ResponseEntity.ok(fournisseurService.getEmptyFournisseur());
    }

    @GetMapping("deleteFournisseur/{idFournisseur}")
    public ResponseEntity<FournisseurDto> deleteFournisseur(@PathVariable long idFournisseur) {
        return ResponseEntity.ok(fournisseurService.deleteFournisseur(idFournisseur));
    }

    // ---------- POSTMAPPING ---------- //

    @PostMapping("create")
    public ResponseEntity<FournisseurDto> createFournisseur(@RequestBody FournisseurDto fournisseurDto) {
        return ResponseEntity.ok(fournisseurService.createFournisseur(fournisseurDto));
    }
}
