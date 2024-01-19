package com.testa.back.model.modelDto;

import java.sql.Timestamp;
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
    private String numero;
    private String nom;
    private int stock;
    private boolean actif;
    private Timestamp dateCreation;
    private List<Long> listIdCategorie;
    private List<Long> listIdFournisseur;

    public ProduitDto() {
        this.id = 0;
        this.numero = "";
        this.nom = "";
        this.stock = 0;
        this.actif = false;
        this.dateCreation = new Timestamp(System.currentTimeMillis());
        this.listIdCategorie = new ArrayList<Long>();
        this.listIdFournisseur = new ArrayList<Long>();
    }

    public ProduitDto(Produit produit) {
        this.id = produit.getId();
        this.numero = produit.getNumero();
        this.nom = produit.getNom();
        this.stock = 0;
        this.actif = produit.isActif();
        this.dateCreation = produit.getDateCreation();
        this.listIdCategorie = new ArrayList<Long>();
        this.listIdFournisseur = new ArrayList<Long>();
    }
}
