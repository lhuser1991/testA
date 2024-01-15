package com.testa.back.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.testa.back.model.modelDto.ProduitDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "produit")
public class Produit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "stock")
    private int stock;

    @Column(name = "actif")
    private boolean actif;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categorie", referencedColumnName = "id", updatable = false)
    private Categorie categorie;
    
    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private Set<ProduitFournisseur> listProduitFournisseur;

    public Produit(ProduitDto produitDto) {
        this.nom = produitDto.getNom();
        this.stock = produitDto.getStock();
    }

}
