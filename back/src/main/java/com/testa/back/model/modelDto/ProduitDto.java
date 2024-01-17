package com.testa.back.model.modelDto;

import java.util.ArrayList;
import java.util.List;

import com.testa.back.model.Produit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProduitDto {
    
    private long id;
    private String nom;
    private int stock;
    private boolean actif;
    private long idCategorie;
    private List<Long> listIdFournisseur;

    public ProduitDto() {
        this.id = 0;
        this.nom = "";
        this.stock = 0;
        this.actif = false;
        this.idCategorie = 0;
        this.listIdFournisseur = new ArrayList<Long>();
    }

    public ProduitDto(Produit produit) {
        this.id = produit.getId();
        this.nom = produit.getNom();
        this.stock = produit.getStock();
        this.actif = produit.isActif();
        this.idCategorie = produit.getCategorie().getId();
        this.listIdFournisseur = new ArrayList<Long>();
    }
}
