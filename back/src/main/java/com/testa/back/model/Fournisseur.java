package com.testa.back.model;

import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.testa.back.model.modelDto.FournisseurDto;

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
@Table(name = "fournisseur")
public class Fournisseur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "identifiant")
    private String identifiant;

    @Column(name = "nom")
    private String nom;

    @Column(name = "actif")
    private boolean actif;

    @Column(name = "date_creation")
    private Timestamp dateCreation;

    @JsonIgnore
    @OneToMany(mappedBy = "fournisseur")
    private Set<ProduitFournisseur> listProduitFournisseur;

    public Fournisseur() {
        this.id = 0;
        this.identifiant = "";
        this.nom = "";
        this.actif = false;
        this.dateCreation = new Timestamp(System.currentTimeMillis());
    }

   /**
    * Constructeur pour la creation d'un Fournisseur.
    * Renvoie un Fournisseur avec nom=nom, identifiant=identifiant et actif=true.
    * @param nom
    * @param identifiant
    */
    public Fournisseur(String nom, String identifiant) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.actif = true;
        this.dateCreation = new Timestamp(System.currentTimeMillis());
    }

    public Fournisseur(FournisseurDto fournisseurDto) {
        this.identifiant = fournisseurDto.getIdentifiant();
        this.nom = fournisseurDto.getNom();
        this.actif = fournisseurDto.isActif();
        this.dateCreation = new Timestamp(System.currentTimeMillis());
    }
}
