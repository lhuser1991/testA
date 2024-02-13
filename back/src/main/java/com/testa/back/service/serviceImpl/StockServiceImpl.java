package com.testa.back.service.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Stock;
import com.testa.back.model.modelDto.ProduitDto;
import com.testa.back.model.modelDto.StockDto;
import com.testa.back.repository.StockRepository;
import com.testa.back.service.StockService;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public List<Stock> getAllStockByProduitId(long idProduit) {
        return stockRepository.findAllByProduitId(idProduit);
    }

    @Override
    public Stock getStockActuelByProduitId(long idProduit) {
        Stock stock = stockRepository.findByProduitIdAndActif(idProduit, true);
        if(stock == null) {
            stock = new Stock();
        } 
        return stock;
    }

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public List<Stock> getAllStockActif() {
        return stockRepository.findAllByActif(true);
    }

    @Override
    public Stock addStockToProduit(StockDto stockDto) {
        Stock stock = getStockActuelByProduitId(stockDto.getIdProduit());
        stock.setActif(false);
        stockRepository.save(stock);
        Stock newStock = new Stock(0, new Timestamp(System.currentTimeMillis()), stock.getStock(), true, stock.getProduit());
        newStock.setStock(newStock.getStock() + stockDto.getStock());
        return stockRepository.save(newStock);
    }

    @Override
    public Stock getStockById(long idStock) {
        return stockRepository.findById(idStock).orElse(new Stock());
    }

    @Override
    public Stock removeStockToProduit(StockDto stockDto) {
        Stock stock = getStockActuelByProduitId(stockDto.getIdProduit());
        stock.setActif(false);
        stockRepository.save(stock);
        Stock newStock = new Stock(0, new Timestamp(System.currentTimeMillis()), stock.getStock(), true, stock.getProduit());
        newStock.setStock(newStock.getStock() - stockDto.getStock());
        return stockRepository.save(newStock);

    }

    @Override
    public Stock getEmptyStock() {
        return new Stock();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public List<StockDto> getAllStockDtoByProduitId(long idProduit) {
        List<StockDto> listStockDto = new ArrayList<StockDto>();
        List<Stock> listStock = getAllStockByProduitId(idProduit);
        for(Stock s: listStock) {
            listStockDto.add(new StockDto(s));
        }
        return listStockDto;
    }

    @Override
    public StockDto getStockDtoActuelByProduitId(long idProduit) {
        return new StockDto(getStockActuelByProduitId(idProduit));
    }

    @Override
    public List<StockDto> getAllStockDtoActif() {
        List<StockDto> listStockDto = new ArrayList<StockDto>();
        List<Stock> listStock = getAllStockActif();
        for(Stock s: listStock) {
            listStockDto.add(new StockDto(s));
        }
        return listStockDto;
    }

    @Override
    public List<StockDto> getAllStockDto() {
        List<StockDto> listStockDto = new ArrayList<StockDto>();
        List<Stock> listStock = getAllStock();
        for(Stock s: listStock) {
            listStockDto.add(new StockDto(s));
        }
        return listStockDto;
    }

    @Override
    public StockDto addStockDtoToProduit(StockDto stockDto) {
        Stock stock = addStockToProduit(stockDto);
        return new StockDto(stock);
    }

    @Override
    public StockDto getStockDtoById(long idStock) {
        Stock stock = getStockById(idStock);
        return new StockDto(stock);
    }

    @Override
    public StockDto removeStockDtoToProduit(StockDto stockDto) {
        Stock stock = removeStockToProduit(stockDto);
        return new StockDto(stock);
    }

    @Override
    public StockDto getEmptyStockDto() {
        Stock stock = getEmptyStock();
        return new StockDto(stock);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public Stock initStock(long idStock) {
        Stock stock = getStockById(idStock);
        if(stock.getId() != 0) {
            Stock initStock = new Stock();
            initStock.setId(stock.getId());
            initStock.setActif(stock.isActif());
            initStock.setProduit(stock.getProduit());
            initStock.setDateCreation(new Timestamp(System.currentTimeMillis()));
        }
        return stock;
    }

    public StockDto initStockDto(long idStock) {
        Stock stock = initStock(idStock);
        return new StockDto(stock.getId(), stock.getDateCreation(), 0, stock.isActif(), stock.getProduit().getId());

    }



}
