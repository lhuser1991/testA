package com.testa.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testa.back.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{
    
    List<Stock> findAllByProduitId(long idProduit);
    List<Stock> findAllByProduitNumero(String numeroProduit);
}
