package com.testa.back.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
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
@Getter
@Setter
@Entity
@Table(name = "stock")
public class Stock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_creation")
    private Timestamp dateCreation;

    @Column(name = "stock")
    private int stock;

    @Column(name = "actif")
    private boolean actif;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produit", referencedColumnName = "id", updatable = true)
    private Produit produit;

    public Stock() {
        this.id = 0;
        this.stock = 0;
        this.actif = false;
        this.produit = new Produit();
    }

    public Stock(Stock stock) {
        this.stock = stock.getStock();
        this.actif = stock.isActif();
    }

}
