package com.testa.back.model.modelDto;

import java.util.ArrayList;
import java.util.List;

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
    private long idCategorie;
    private List<Long> listIdFournisseur;

    public ProduitDto() {
        this.id = 0;
        this.nom = "";
        this.stock = 0;
        this.idCategorie = 0;
        this.listIdFournisseur = new ArrayList<Long>();
    }
}
