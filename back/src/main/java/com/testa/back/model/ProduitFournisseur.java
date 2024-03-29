package com.testa.back.model;

import com.testa.back.model.modelDto.ProduitFournisseurDto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "produit_fournisseur")
public class ProduitFournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produit", referencedColumnName = "id", updatable = true)
    private Produit produit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_fournisseur", referencedColumnName = "id", updatable = true)
    private Fournisseur fournisseur;

    public ProduitFournisseur(Produit produit, Fournisseur fournisseur) {
        this.produit = produit;
        this.fournisseur = fournisseur;
    }

    public ProduitFournisseur(ProduitFournisseurDto produitFournisseurDto) {
        this.id = produitFournisseurDto.getId();
    }
}
