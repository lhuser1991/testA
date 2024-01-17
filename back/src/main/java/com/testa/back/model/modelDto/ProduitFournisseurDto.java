package com.testa.back.model.modelDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProduitFournisseurDto {
    
    private long id;
    private boolean fourni;
    private long idProduit;
    private long idFournisseur;

}
