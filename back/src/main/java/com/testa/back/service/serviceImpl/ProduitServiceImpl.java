package com.testa.back.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Categorie;
import com.testa.back.model.Fournisseur;
import com.testa.back.model.Produit;
import com.testa.back.model.ProduitCategorie;
import com.testa.back.model.ProduitFournisseur;
import com.testa.back.model.Stock;
import com.testa.back.model.generic.GenericResponse;
import com.testa.back.model.modelDto.ProduitDto;
import com.testa.back.repository.CategorieRepository;
import com.testa.back.repository.FournisseurRepository;
import com.testa.back.repository.ProduitCategorieRepository;
import com.testa.back.repository.ProduitFournisseurRepository;
import com.testa.back.repository.ProduitRepository;
import com.testa.back.repository.StockRepository;
import com.testa.back.service.CategorieService;
import com.testa.back.service.ProduitCategorieService;
import com.testa.back.service.ProduitFournisseurService;
import com.testa.back.service.ProduitService;
import com.testa.back.service.StockService;

@Service
public class ProduitServiceImpl implements ProduitService{
    
    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;
    private final FournisseurRepository fournisseurRepository;
    private final ProduitFournisseurRepository produitFournisseurRepository;
    private final ProduitCategorieRepository produitCategorieRepository;
    private final StockRepository stockRepository;
    private final CategorieService categorieService;
    private final StockService stockService;
    private final ProduitCategorieService produitCategorieService;
    private final ProduitFournisseurService produitFournisseurService;

    public ProduitServiceImpl(
        ProduitRepository produitRepository,
        CategorieRepository categorieRepository,
        FournisseurRepository fournisseurRepository,
        ProduitFournisseurRepository produitFournisseurRepository,
        ProduitCategorieRepository produitCategorieRepository,
        StockRepository stockRepository,
        CategorieService categorieService,
        StockService stockService,
        ProduitCategorieService produitCategorieService,
        ProduitFournisseurService produitFournisseurService
        ) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.produitFournisseurRepository = produitFournisseurRepository;
        this.produitCategorieRepository = produitCategorieRepository;
        this.stockRepository = stockRepository;
        this.categorieService = categorieService;
        this.stockService = stockService;
        this.produitCategorieService = produitCategorieService;
        this.produitFournisseurService = produitFournisseurService;
    }

    ///////////////////////////////////////////////////////
    // ------------------------------------------------- //
    // -------------------- PRODUIT -------------------- //
    // ------------------------------------------------- //
    ///////////////////////////////////////////////////////

    @Override
    public Produit getProduiById(long idProduit) {
        return produitRepository.findById(idProduit).orElse(new Produit());
    }

    @Override
    public Produit getProduitByNom(String nomProduit) {
        Produit produit = produitRepository.findByNom(nomProduit);
        if(produit != null) {
            return produit;
        } else {
            return new Produit();
        }
    }

    @Override
    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> getAllProduitActif() {
        return produitRepository.findAllByActif(true);
    }

    @Override
    public Produit getEmptyProduit() {
        return new Produit();
    }

    @Override
    public Produit deleteProduitById(long idProduit) {
        Produit produit = getProduiById(idProduit);
        if(produit.getId() != 0) {
            produit.setActif(false);
            produitRepository.save(produit);
        }
        return produit;
    }

    @Override
    public List<Produit> getAllProduitByNumeroProduit(String numeroProduit) {
        return produitRepository.findAllByNumero(numeroProduit);
    }

    ///////////////////////////////////////////////////////////
    // ----------------------------------------------------- //
    // -------------------- PRODUIT_DTO -------------------- //
    // ----------------------------------------------------- //
    ///////////////////////////////////////////////////////////

    @Override
    public ProduitDto getProduitDtoById(long idProduit) {
        Produit produit = getProduiById(idProduit);
        if(produit.getId() != 0) {
            return convertProduitIntoProduitDto(produit);
        } else {
            return new ProduitDto();
        }
    }

    @Override
    public ProduitDto getProduitDtoByNom(String nomProduit) {
        Produit produit = getProduitByNom(nomProduit);
        if(produit.getId() != 0) {
            return convertProduitIntoProduitDto(produit);
        } else {
            return new ProduitDto();
        }
    }

    @Override
    public List<ProduitDto> getAllProduitDto() {
        List<Produit> listProduit = getAllProduit();
        List<ProduitDto> listProduitDto = new ArrayList<ProduitDto>();
        for(Produit p: listProduit) {
            listProduitDto.add(convertProduitIntoProduitDto(p));
        }
        return listProduitDto;
    }

    @Override
    public List<ProduitDto> getAllProduiDtotActif() {
        List<Produit> listProduit = getAllProduitActif();
        List<ProduitDto> listProduitDto = new ArrayList<ProduitDto>();
        for(Produit p: listProduit) {
            listProduitDto.add(convertProduitIntoProduitDto(p));
        }
        return listProduitDto;
    }
    
    @Override
    public ProduitDto getEmptyProduitDto() {
        return new ProduitDto();
    }

    @Override
    public ProduitDto deleteProduitDtoById(long idProduit) {
        Produit produit = deleteProduitById(idProduit);
        if(produit.getId() != 0) {
            return convertProduitIntoProduitDto(produit);
        } else {
            return getEmptyProduitDto();
        }
    }

    @Override
    public GenericResponse<ProduitDto> createProduit(ProduitDto produitDto) {

        if(!verificationNumeroProduit(produitDto)) {
            return new GenericResponse<>(produitDto,"Erreur, le numero de produit "+produitDto.getNumero()+" existe deja.");
        } else if(!verificationListeIdCategorie(produitDto)) {
            return new GenericResponse<>(produitDto, "Erreur, les categories entrées n'existent pas.");
        } else if(!verificationListeIdFournisseur(produitDto)) {
            return new GenericResponse<>(produitDto, "Erreur, les fournisseurs entrés n'existent pas.");
        } else {
            
            // Creer et save un nouveau produit
            Produit newProduit = new Produit(produitDto.getNumero(), produitDto.getNom());
            produitRepository.save(newProduit);
    
            // Creer et save un nouveau stock
            Stock newStock = new Stock();
            newStock.setStock(produitDto.getStock());
            newStock.setProduit(newProduit);
            newStock.setActif(true);
            stockRepository.save(newStock);
    
            // Creer et save une nouvelle liste de produitcategorie
            List<Categorie> listCategorie = new ArrayList<Categorie>();
            for(long idCategorie: produitDto.getListIdCategorie()) {
                listCategorie.add(categorieService.getCategorieById(idCategorie));
            }
            List<ProduitCategorie> newListProduitCategorie = new ArrayList<ProduitCategorie>();
            for(Categorie c: listCategorie) {
                newListProduitCategorie.add(new ProduitCategorie(newProduit, c));
            }
            produitCategorieRepository.saveAll(newListProduitCategorie);
    
            // Creer et save une nouvelle liste de produitfournisseur
            List<Fournisseur> listFournisseur = new ArrayList<Fournisseur>();
            for(long idFournisseur: produitDto.getListIdFournisseur()) {
                listFournisseur.add(fournisseurRepository.findById(idFournisseur).orElse(new Fournisseur()));
            }
            List<ProduitFournisseur> newListProduitFournisseur = new ArrayList<ProduitFournisseur>();
            for(Fournisseur f: listFournisseur) {
                newListProduitFournisseur.add(new ProduitFournisseur(newProduit, f));
            }
            produitFournisseurRepository.saveAll(newListProduitFournisseur);
    
            // Creer un nouveau produitDto
            ProduitDto newProduitDto = new ProduitDto(newProduit);
            newProduitDto.setStock(newStock.getStock());
            for(ProduitCategorie pc: newListProduitCategorie) {
                newProduitDto.getListIdCategorie().add(pc.getCategorie().getId());
            }
            for(ProduitFournisseur pf: newListProduitFournisseur) {
                newProduitDto.getListIdFournisseur().add(pf.getFournisseur().getId());
            }
            
            return new GenericResponse<ProduitDto>(newProduitDto, "Nouveau produit ajouté.");

        }
    }

    @Override
    public GenericResponse<ProduitDto> updateProduit(ProduitDto produitDto) {
        if(produitDto.getId() == 0) {
            return new GenericResponse<>(produitDto,"Produit non modifié");
        } else {

            // Save la liste des produits contenant les anciens produit et le nouveau produit.
            // Les anciens sont mis avec actif = false et le nouveau avec un actif = true.
            List<Produit> listProduit = getAllProduitByNumeroProduit(produitDto.getNumero());
            List<Produit> updateListProduit = new ArrayList<Produit>();
            for(Produit p: listProduit) {
                p.setActif(false);
                updateListProduit.add(p);
            }
            Produit updateProduit = new Produit(produitDto);
            updateListProduit.add(updateProduit);
            produitRepository.saveAll(updateListProduit);

            // Recupere le Stock actif de l'ancien Produit, le mete à jour avec le Produit update,
            // recupere la liste des anciens stock de l'ancien produit et met actif à false,
            // ajoute le Stock update dans la liste de Stock update et save la liste. 
            Stock stock = stockService.getStockActuelByProduitId(produitDto.getId());
            Stock updateStock = new Stock(stock);
            updateStock.setProduit(updateProduit);
            List<Stock> updateListStock = new ArrayList<Stock>();
            List<Stock> listStock = stockService.getAllStock();
            for(Stock s: listStock) {
                if(s.getProduit().getId() == produitDto.getId()) {
                    s.setActif(false);
                    updateListStock.add(s);
                }
            }
            updateListStock.add(updateStock);
            stockRepository.saveAll(updateListStock);

            // Recupere la liste de produitcategorie de l'ancien produit, puis les mets à jour
            // avec le nouveau produit, puis sauvegarde la nouvelle liste
            List<ProduitCategorie> listProduitCategorie = produitCategorieService.getAllByProduitId(produitDto.getId());
            List<ProduitCategorie> updateListProduitCategorie = new ArrayList<ProduitCategorie>();
            for(ProduitCategorie pc: listProduitCategorie) {
                ProduitCategorie updateProduitCategorie = new ProduitCategorie();
                updateProduitCategorie.setProduit(updateProduit);
                updateProduitCategorie.setCategorie(pc.getCategorie());
                updateListProduitCategorie.add(updateProduitCategorie);
            }
            produitCategorieRepository.saveAll(updateListProduitCategorie);

            // Recupere la liste de produitfournisseur de l'ancien produit, puis les mets à jour
            // avec le nouveau produit, puis sauvegarde la nouvelle liste
            List<ProduitFournisseur> listProduitFournisseur = produitFournisseurService.getAllByProduitId(produitDto.getId());
            List<ProduitFournisseur> updateListProduitFournisseur = new ArrayList<ProduitFournisseur>();
            for(ProduitFournisseur pf: listProduitFournisseur) {
                ProduitFournisseur updateProduitFournisseur = new ProduitFournisseur();
                updateProduitFournisseur.setProduit(updateProduit);
                updateProduitFournisseur.setFournisseur(pf.getFournisseur());
                updateListProduitFournisseur.add(updateProduitFournisseur);
            }
            produitFournisseurRepository.saveAll(updateListProduitFournisseur);

            return new GenericResponse<>(convertProduitIntoProduitDto(updateProduit),"Produit modifié.");

        }
    }

    @Override
    public List<ProduitDto> getAllProduitDtoByNumeroProduit(String numeroProduit) {
        List<Produit> listProduit = getAllProduitByNumeroProduit(numeroProduit);
        List<ProduitDto> listProduitDto = new ArrayList<ProduitDto>();

        for(Produit p: listProduit) {          
            listProduitDto.add(convertProduitIntoProduitDto(p));            
        }

        return listProduitDto;
    }

    public ProduitDto convertProduitIntoProduitDto(Produit produit) {
        // Convertit produit en produitDto
        ProduitDto produitDto = new ProduitDto(produit);

        // Initialise le stock de produitDto
        produitDto.setStock(stockService.getStockActuelByProduitId(produitDto.getId()).getStock());

        // Initialise la listeIdFournisseur de produitDto
        for(ProduitFournisseur pf: produitFournisseurService.getAllByProduitId(produit.getId())) {
            produitDto.getListIdFournisseur().add(pf.getFournisseur().getId());
        }

        // Initialise la listeIdCatagorie de produitDto
        for(ProduitCategorie pc: produitCategorieService.getAllByProduitId(produit.getId())) {
            produitDto.getListIdCategorie().add(pc.getCategorie().getId());
        }

        return produitDto;
    }

    public boolean verificationNumeroProduit(ProduitDto produitDto) {
        boolean check = true;
        if(produitRepository.existsByNumero(produitDto.getNumero())) {
            check = false;
        } 
        return check;
    }

    public boolean verificationListeIdCategorie(ProduitDto produitDto) {
        boolean check = true;
        for(long idCategorie: produitDto.getListIdCategorie()) {
            if(!categorieRepository.existsById(idCategorie)) {
                check = false;
            }
        }
        return check;
    }

    public boolean verificationListeIdFournisseur(ProduitDto produitDto) {
        boolean check = true;
        for(long idFournisseur: produitDto.getListIdFournisseur()) {
            if(!fournisseurRepository.existsById(idFournisseur)) {
                check = false;
            }
        }
        return check;
    }



}
