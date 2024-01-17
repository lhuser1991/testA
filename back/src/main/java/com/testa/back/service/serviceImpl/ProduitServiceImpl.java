package com.testa.back.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Categorie;
import com.testa.back.model.Fournisseur;
import com.testa.back.model.Produit;
import com.testa.back.model.ProduitFournisseur;
import com.testa.back.model.generic.GenericResponse;
import com.testa.back.model.modelDto.ProduitDto;
import com.testa.back.repository.CategorieRepository;
import com.testa.back.repository.FournisseurRepository;
import com.testa.back.repository.ProduitFournisseurRepository;
import com.testa.back.repository.ProduitRepository;
import com.testa.back.service.CategorieService;
import com.testa.back.service.FournisseurService;
import com.testa.back.service.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService{
    
    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;
    private final FournisseurRepository fournisseurRepository;
    private final ProduitFournisseurRepository produitFournisseurRepository;
    private final CategorieService categorieService;
    private final FournisseurService fournisseurService;

    public ProduitServiceImpl(
        ProduitRepository produitRepository,
        CategorieRepository categorieRepository,
        FournisseurRepository fournisseurRepository,
        ProduitFournisseurRepository produitFournisseurRepository,
        CategorieService categorieService,
        FournisseurService fournisseurService
        ) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.produitFournisseurRepository = produitFournisseurRepository;
        this.categorieService = categorieService;
        this.fournisseurService = fournisseurService;
    }

    @Override
    public ProduitDto getProduitById(long idProduit) {
        Produit produit = produitRepository.findById(idProduit).orElse(null);
        if(produit != null) {
            return new ProduitDto(produit);
        } else {
            return new ProduitDto();
        }

    }

    @Override
    public ProduitDto getProduitByNom(String nomProduit) {
        Produit produit = produitRepository.findByNom(nomProduit);
        if(produit == null) {
            return new ProduitDto(produit);
        }
        return new ProduitDto();
    }

    @Override
    public List<ProduitDto> getAllProduit() {
        List<Produit> listProduit = produitRepository.findAll();
        List<ProduitDto> listProduitDto = new ArrayList<ProduitDto>();
        for(Produit p: listProduit) {
            listProduitDto.add(new ProduitDto(p));
        }
        return listProduitDto;
    }

    @Override
    public List<ProduitDto> getAllProduitByIdCategorie(long idCategorie) {
        Categorie categorie = categorieRepository.findById(idCategorie).orElse(null);
        if(categorie != null) {
            List<Produit> listProduit = produitRepository.findAllByCategorieId(idCategorie);
            List<ProduitDto> listProduitDto = new ArrayList<ProduitDto>();
            for(Produit p: listProduit) {
                listProduitDto.add(new ProduitDto(p));
            }
            return listProduitDto;
        } else {
            return new ArrayList<ProduitDto>();
        }
    }

    @Override
    public List<ProduitDto> getAllProduitByNomCategorie(String nomCategorie) {
        Categorie categorie = categorieRepository.findByNom(nomCategorie);
        if(categorie != null) {
            List<Produit> listProduit = produitRepository.findAllByCategorieNom(nomCategorie);
            List<ProduitDto> listProduitDto = new ArrayList<ProduitDto>();
            for(Produit p: listProduit) {
                listProduitDto.add(new ProduitDto(p));
            }
            return listProduitDto;
        } else {
            return new ArrayList<ProduitDto>();
        }
    }

    @Override
    public List<ProduitDto> getAllProduitActif() {
        List<Produit> listProduit = produitRepository.findAllByActif(true);
        List<ProduitDto> listProduitDto = new ArrayList<ProduitDto>();
        for(Produit p: listProduit) {
            listProduitDto.add(new ProduitDto(p));
        }
        return listProduitDto;
    }

    @Override
    public List<ProduitDto> getAllProduitActifByIdCategorie(long idCategorie) {
        Categorie categorie = categorieRepository.findById(idCategorie).orElse(null);
        if(categorie != null) {
            List<Produit> listProduit = produitRepository.findAllByActifAndCategorieId(true, idCategorie);
            List<ProduitDto> listProduitDto = new ArrayList<ProduitDto>();
            for(Produit p: listProduit) {
                listProduitDto.add(new ProduitDto(p));
            }
            return listProduitDto;
        } else {
            return new ArrayList<ProduitDto>();
        }
    }

    @Override
    public List<ProduitDto> getAllProduitActifByNomCategorie(String nomCategorie) {
        Categorie categorie = categorieRepository.findByNom(nomCategorie);
        if(categorie != null) {
            List<Produit> listProduit = produitRepository.getAllByActifAndCategorieNom(true, nomCategorie);
            List<ProduitDto> listProduitDto = new ArrayList<ProduitDto>();
            for(Produit p: listProduit) {
                listProduitDto.add(new ProduitDto(p));
            }
            return listProduitDto;
        } else {
            return new ArrayList<ProduitDto>();
        }
    }

    @Override
    public ProduitDto emptyProduit() {
        return new ProduitDto();
    }

    @Override
    public ProduitDto deleteProduitById(long idProduit) {
        Produit produit = produitRepository.findById(idProduit).orElse(null);
        if(produit != null) {
            produit.setActif(false);
            produitRepository.save(produit);
        }
        return convertProduitIntoProduitDto(produit);
    }

    @Override
    public GenericResponse<ProduitDto> createProduit(ProduitDto produitDto) {
        // On veut savoir si la categorie existe pour cet id
        Categorie categorie = categorieService.getCategorieById(produitDto.getId());

        // Initialisation du message
        String message = "";

        // On recherche les fournisseurs par les id contenues dans produitDto.getListIdFournisseur()
        // puis on les ajoutes dans listFournisseurs
        List<Fournisseur> listFournisseurs = fournisseurService.getAllFournisseurFromListFournisseurId(produitDto.getListIdFournisseur());

        // On crée un nouveau produit
        Produit produit = initProduit(produitDto);

        if(categorie != null && listFournisseurs.size() == produitDto.getListIdFournisseur().size()) {
            produit.setCategorie(categorie);
            produitRepository.save(produit);

            // Permet d'initialiser une liste de ProduitFournisseur
            List<Fournisseur> allFournisseurs = fournisseurRepository.findAllByActif(true);
            List<ProduitFournisseur> newListProduitFournisseur= new ArrayList<ProduitFournisseur>();
            for(Fournisseur f: allFournisseurs) {
                newListProduitFournisseur.add(new ProduitFournisseur(false,produit,f));
            }
            for(ProduitFournisseur pf: newListProduitFournisseur) {
                for(Fournisseur f: listFournisseurs) {
                    if(pf.getFournisseur().getId() == f.getId()) {
                        pf.setFourni(true);
                    }
                }
            }
            
            // Si premiere creation d'un produit
            if(produitDto.getId() == 0) {
                produitFournisseurRepository.saveAll(newListProduitFournisseur);
                message = "Produit ajouté.";
            }

            // Si modification
            if(produitDto.getId() != 0) {
                List<ProduitFournisseur> listProduitFournisseur = produitFournisseurRepository.findAllFournisseurByProduitId(produit.getId());
                for(ProduitFournisseur pf: listProduitFournisseur) {
                    for(ProduitFournisseur pf1: newListProduitFournisseur) {
                        if(pf.getProduit().getId() == pf1.getProduit().getId() && pf.getFournisseur().getId() == pf1.getFournisseur().getId()) {
                            pf.setFourni(pf1.isFourni());
                        }
                    }
                }
                produitFournisseurRepository.saveAll(listProduitFournisseur);
                message = "Produit modifié.";
            }

        } else {
            produit.setCategorie(new Categorie());
            message = "Erreur. Produit non ajouté";
        }

        ProduitDto newProduitDto = convertProduitIntoProduitDto(produit);

        return new GenericResponse<>(newProduitDto, message);
    }

    public ProduitDto convertProduitIntoProduitDto(Produit produit) {
        ProduitDto produitDto = new ProduitDto(produit);
        for(ProduitFournisseur pf: produitFournisseurRepository.findAllFournisseurByProduitIdAndFourni(produit.getId(), true)) {
            produitDto.getListIdFournisseur().add(pf.getFournisseur().getId());
        }
        return produitDto;
    }

    public Produit initProduit(ProduitDto produitDto) {
        Produit produit = new Produit();
        if(produitDto.getId() != 0) {
            // Pour la modification
            produit = new Produit(produitDto.getId(),produitDto.getNom(), produitDto.getStock(), produitDto.isActif());
        } else {
            // Pour la création
            produit = new Produit(produitDto.getNom(), produitDto.getStock());
            produit.setActif(true);
        }
        return produit;
    }

}
