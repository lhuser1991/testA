package com.testa.back.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testa.back.model.Stock;
import com.testa.back.model.modelDto.ProduitDto;
import com.testa.back.model.modelDto.StockDto;
import com.testa.back.service.StockService;

@RestController
@RequestMapping("testa/stock/")
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    // ---------- GETMAPPING ---------- //

    @GetMapping("{idStock}")
    public ResponseEntity<StockDto> getStockById(@PathVariable long idStock) {
        return ResponseEntity.ok(stockService.getStockDtoById(idStock));
    }

    @GetMapping("list")
    public ResponseEntity<List<StockDto>> getAllStock() {
        return ResponseEntity.ok(stockService.getAllStockDto());
    }

    @GetMapping("list/actif")
    public ResponseEntity<List<StockDto>> getAllStockActif() {
        return ResponseEntity.ok(stockService.getAllStockDtoActif());
    }

    @GetMapping("{idProduit}/list")
    public ResponseEntity<List<StockDto>> getAllStockByProduitId(@PathVariable long idProduit) {
        return ResponseEntity.ok(stockService.getAllStockDtoByProduitId(idProduit));
    }

    @GetMapping("{idProduit}/stockActuel")
    public ResponseEntity<StockDto> getStockActuelByProduitId(@PathVariable long idProduit) {
        return ResponseEntity.ok(stockService.getStockDtoActuelByProduitId(idProduit));
    }

    // ---------- POSTMAPPING ---------- //

    @GetMapping("addStock")
    public ResponseEntity<StockDto> addStockToProduit(@RequestBody StockDto stockDto) {
        return ResponseEntity.ok(stockService.addStockDtoToProduit(stockDto));
    }

}
