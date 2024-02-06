package com.testa.back.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
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
@Getter
@Setter
@Entity
@Table(name = "produit")
public class Produit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "nom")
    private String nom;

    @Column(name = "actif")
    private boolean actif;

    @Column(name = "date_creation")
    private Timestamp dateCreation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_operation", referencedColumnName = "id", updatable = true)
    private Operation operation;

    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private Set<ProduitCategorie> listProduitCategorie;
    
    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private Set<ProduitFournisseur> listProduitFournisseur;

    /**
     * Constructeur pour la premiere creation d'un objet Produit.
     * Il renvoie un objet Produit avec les attributs numero = numero, nom = nom, timestamp= date du jour et actif à true
     * @param numero Le numero de l'objet Produit
     * @param nom Le nom de l'objet Produit
     */
    public Produit(String numero, String nom) {
        this.numero = numero;
        this.nom = nom;
        this.dateCreation = new Timestamp(System.currentTimeMillis());
        this.actif = true;
    }

    /**
     * Constructeur pour l'update d'un Produit.
     * Il renvoie un objet Produit avec les attributs numero = produitDto.getNumero(), 
     * nom = produitDto.getNom(), timestamp = date du jour et actif = produitDto.isActif()
     * @param produitDto Le ProduitDto qui servira à modifier le Produit
     */
    public Produit(ProduitDto produitDto) {
        this.numero = produitDto.getNumero();
        this.nom = produitDto.getNom();
        this.dateCreation = new Timestamp(System.currentTimeMillis());
        this.actif = produitDto.isActif();
    }

    public Produit() {
        this.id = 0;
        this.numero = "";
        this.nom = "";
        this.actif = false;
        this.dateCreation = new Timestamp(System.currentTimeMillis());
        this.listProduitCategorie = new HashSet<ProduitCategorie>();
        this.listProduitFournisseur = new HashSet<ProduitFournisseur>();
    }   

}
