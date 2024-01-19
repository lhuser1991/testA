package com.testa.back.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Stock;
import com.testa.back.repository.StockRepository;
import com.testa.back.service.StockService;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> getAllStockByProduitId(long idProduit) {
        return stockRepository.findAllByProduitId(idProduit);
    }

    @Override
    public Stock getStockActuelByProduitId(long idProduit) {
        Stock stockActuel = new Stock();

        List<Stock> listStock = getAllStockByProduitId(idProduit);
        for(Stock s: listStock) {
            if(s.isActif() == true) {
                stockActuel = s;
            }
        }

        return stockActuel;
    }

    @Override
    public List<Stock> getAllStockByProduitNumero(String numeroProduit) {
        return stockRepository.findAllByProduitNumero(numeroProduit);
    }

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }
    
}
