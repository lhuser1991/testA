package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Stock;

public interface StockService {
    
    /**
     * Permet d'obtenir ls liste des objets Stock d'un objet Produit
     * @param idProduit L'id de l'objet Produit que l'on veut obtenir
     * @return Une liste d'objet Stock
     */
    List<Stock> getAllStockByProduitId(long idProduit);

    /**
     * Permet d'obtenir la liste des Stock d'un Produit par son numero
     * @param numeroProduit Le numero du Produit
     * @return Une liste de Stock
     */
    List<Stock> getAllStockByProduitNumero(String numeroProduit);

    /**
     * Permet d'obtenir le stock actuel de la liste des stocks d'un ibjet Produit
     * @param idProduit L'id de l'objet Produit que l'on veut obtenir
     * @return Un objet Stock
     */
    Stock getStockActuelByProduitId(long idProduit);

    /**
     * Permet d'obtenir une liste de Stock
     * @return Une liste de Stock
     */
    List<Stock> getAllStock();
}
