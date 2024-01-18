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

import com.testa.back.model.Etat;
import com.testa.back.service.EtatService;

@RestController
@RequestMapping("testa/etat/")
@CrossOrigin(origins = "http://localhost:4200")
public class EtatController {
    
    private final EtatService etatService;

    public EtatController(EtatService etatService) {
        this.etatService = etatService;
    }

    // ---------- GETMAPPING ---------- //

    @GetMapping("id/{idEtat}")
    public ResponseEntity<Etat> getEtatById(@PathVariable long idEtat) {
        return ResponseEntity.ok(etatService.getEtatById(idEtat));
    }

    @GetMapping("nom/{nomEtat}")
    public ResponseEntity<Etat> getEtatByNom(@PathVariable String nomEtat) {
        return ResponseEntity.ok(etatService.getEtatByNom(nomEtat));
    }

    @GetMapping("list")
    public ResponseEntity<List<Etat>> getAllEtat() {
        return ResponseEntity.ok(etatService.getAllEtat());
    }

    @GetMapping("list/actif")
    public ResponseEntity<List<Etat>> getAllEtatActif() {
        return ResponseEntity.ok(etatService.getAllEtatActif());
    }

    @GetMapping("deleteEtat/{idEtat}")
    public ResponseEntity<Etat> deleteEtat(@PathVariable long idEtat) {
        return ResponseEntity.ok(etatService.deleteEtat(idEtat));
    }

    // ---------- POSTMAPPING ---------- //

    @PostMapping("createEtat")
    public ResponseEntity<Etat> createEtat(@RequestBody Etat etat) {
        return ResponseEntity.ok(etatService.createEtat(etat));
    }
}
