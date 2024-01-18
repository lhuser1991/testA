package com.testa.back.model;

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
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "fournisseur")
public class Fournisseur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "actif")
    private boolean actif;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_etat", referencedColumnName = "id", updatable = true)
    private Etat etat;

    @JsonIgnore
    @OneToMany(mappedBy = "fournisseur")
    private Set<ProduitFournisseur> listProduitFournisseur;

    /**
     * Pour la création
     * @param nom
     */
    public Fournisseur(String nom) {
        this.nom = nom;
        this.actif = true;
    }

    public Fournisseur(FournisseurDto fournisseurDto) {
        this.id = fournisseurDto.getId();
        this.nom = fournisseurDto.getNom();
        this.actif = fournisseurDto.isActif();
    }
}
