package com.testa.back.model.modelDto;

import com.testa.back.model.Stock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StockDto {
    
    private long id;
    private int stock;
    private boolean actif;
    private long idProduit;

    public StockDto() {
        this.id = 0;
        this.stock = 0;
        this.actif = false;
        this.idProduit = 0;
    }

    public StockDto(Stock stock) {
        this.id = stock.getId();
        this.stock = stock.getStock();
        this.actif = stock.isActif();
        this.idProduit = stock.getProduit().getId();
    }
}
