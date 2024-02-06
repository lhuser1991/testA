package com.testa.back.model.modelDto;

import java.sql.Timestamp;

import com.testa.back.model.Fournisseur;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FournisseurDto {
    
    private long id;
    private String identifiant;
    private String nom;
    private boolean actif;
    private Timestamp dateCreation;

    public FournisseurDto() {
        this.id = 0;
        this.identifiant = "";
        this.nom = "";
        this.actif = false;
        this.dateCreation = new Timestamp(System.currentTimeMillis());
    }

    public FournisseurDto(Fournisseur fournisseur) {
        this.id = fournisseur.getId();
        this.identifiant = fournisseur.getIdentifiant();
        this.nom = fournisseur.getNom();
        this.actif = fournisseur.isActif();
        this.dateCreation = fournisseur.getDateCreation();
    }
}
