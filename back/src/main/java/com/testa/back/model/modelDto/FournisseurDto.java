package com.testa.back.model.modelDto;

import com.testa.back.model.Fournisseur;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FournisseurDto {
    
    private long id;
    private String nom;
    private boolean actif;
    private long idEtat;

    public FournisseurDto() {
        this.id = 0;
        this.nom = "";
        this.actif = false;
        this.idEtat = 0;
    }

    public FournisseurDto(Fournisseur fournisseur) {
        this.id = fournisseur.getId();
        this.nom = fournisseur.getNom();
        this.actif = fournisseur.isActif();
        this.idEtat =fournisseur.getEtat().getId();
    }
}
