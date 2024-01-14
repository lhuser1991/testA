package com.testa.back.model.modelDto;

import com.testa.back.model.Categorie;

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
    private Categorie categorie;

    public ProduitDto() {
        this.id = 0;
        this.nom = "";
        this.stock = 0;
        this.categorie = null;
    }
}
