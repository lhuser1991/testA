package com.testa.back.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testa.back.model.Stock;
import com.testa.back.service.StockService;

@RestController
@RequestMapping("testa/stock/")
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("{idProduit}/list")
    public ResponseEntity<List<Stock>> getAllStockByProduitId(@PathVariable long idProduit) {
        return ResponseEntity.ok(stockService.getAllStockByProduitId(idProduit));
    }

    @GetMapping("{idProduit}/list/stockactuel")
    public ResponseEntity<Stock> getStockActuelByProduitId(@PathVariable long idProduit) {
        return ResponseEntity.ok(stockService.getStockActuelByProduitId(idProduit));
    }


}
