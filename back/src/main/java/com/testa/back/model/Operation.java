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
@Table(name = "operation")
public class Operation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "actif")
    private boolean actif;

    @JsonIgnore
    @OneToMany(mappedBy = "operation")
    private Set<Produit> listProduit;

    @JsonIgnore
    @OneToMany(mappedBy = "operation")
    private Set<Fournisseur> listFournisseur;

    public Operation() {
        this.id = 0;
        this.nom = "";
        this.actif = false;
    }

    /**
     * Pour la creation
     * @param nom
     */
    public Operation(String nom) {
        this.nom = nom;
        this.actif = true;
    }

}
