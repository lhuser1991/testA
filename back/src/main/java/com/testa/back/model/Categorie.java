package com.testa.back.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categorie")
public class Categorie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "actif")
    private boolean actif;

    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private Set<Produit> listProduit;

    /**
     * Pour l'initialisation
     */
    public Categorie() {
        this.id = 0;
        this.nom = "";
        this.actif = false;
    }

    /**
     * Pour la creation
     * @param nom
     * @param actif
     */
    public Categorie(String nom) {
        this.nom = nom;
        this.actif = true;
    }

    public Categorie(Categorie categorie) {
        this.id = categorie.getId();
        this.nom = categorie.getNom();
        this.actif = categorie.isActif();
    }

}
