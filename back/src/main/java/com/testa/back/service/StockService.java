package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Stock;
import com.testa.back.model.modelDto.ProduitDto;
import com.testa.back.model.modelDto.StockDto;

public interface StockService {

    /**
     * Permet d'obtenir un Stock par son id
     * @param idStock L'id du Stock à obtenir
     * @return Un objet Stock si l'id est trouvé, sinon un Stock vide
     */
    Stock getStockById(long idStock);

    /**
     * Permet d'obtenir une liste de Stock
     * @return Une liste de Stock
     */
    List<Stock> getAllStock();

    /**
     * Permet d'obtenir ls liste des Stock d'un Produit
     * @param idProduit L'id du Produit que l'on veut obtenir
     * @return Une liste de Stock
     */
    List<Stock> getAllStockByProduitId(long idProduit);

    /**
     * Permet d'obtenir le Stock actuel d'un Produit
     * @param idProduit L'id du Produit que l'on veut obtenir
     * @return Un objet Stock
     */
    Stock getStockActuelByProduitId(long idProduit);

    /**
     * Permet d'obtenir une liste de Stock actif
     * @return Une liste de Stock
     */
    List<Stock> getAllStockActif();

    /**
     * Permet d'ajouter une quantité à un Stock à un Produit
     * @param stockDto Le StockDto qui contient la nouvelle quantité de stock à ajouté
     * @return Le nouveau Stock du Produit
     */
    Stock addStockToProduit(StockDto stockDto);

    /**
     * Permet d'enlever une quantité à un Stock d'un Produit
     * @param stockDto Le StockDto qui contient la nouvelle quantité de stock à enlever
     * @return Le nouveau Stock du Produit
     */
    Stock removeStockToProduit(StockDto stockDto);

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Permet d'obtenir un StockDto par l'id d'un Stock
     * @param idStock L'id du Stock à obtenir
     * @return Un objet StockDto si l'id est trouvé, sinon un StockDto vide
     */
    StockDto getStockDtoById(long idStock);
    
    /**
     * Permet d'obtenir une liste de StockDto
     * @return Une liste de StockDto
     */
    List<StockDto> getAllStockDto();

    /**
     * Permet d'obtenir ls liste des StockDto d'un Produit
     * @param idProduit L'id du Produit que l'on veut obtenir
     * @return Une liste de StockDto
     */
    List<StockDto> getAllStockDtoByProduitId(long idProduit);

    /**
     * Permet d'obtenir le StockDto actuel d'un Produit
     * @param idProduit L'id du Produit que l'on veut obtenir
     * @return Un objet StockDto
     */
    StockDto getStockDtoActuelByProduitId(long idProduit);
    
    /**
     * Permet d'obtenir une liste de StockDto actif
     * @return Une liste de StockDto
     */
    List<StockDto> getAllStockDtoActif();

    /**
     * Permet d'ajouter une quantité à un Stock à un Produit
     * @param stockDto Le StockDto qui contient la nouvelle quantité de stock à ajouté
     * @return Le nouveau StockDto du Produit
     */
    StockDto addStockDtoToProduit(StockDto stockDto);

    /**
     * Permet d'enlever une quantité à un Stock d'un Produit
     * @param stockDto Le StockDto qui contient la nouvelle quantité de stock à enlever
     * @return Le nouveau StockDto du Produit
     */
    StockDto removeStockDtoToProduit(StockDto stockDto);



}
