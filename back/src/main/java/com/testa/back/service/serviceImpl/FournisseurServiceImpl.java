package com.testa.back.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Operation;
import com.testa.back.model.Fournisseur;
import com.testa.back.model.modelDto.FournisseurDto;
import com.testa.back.repository.FournisseurRepository;
import com.testa.back.service.OperationService;
import com.testa.back.service.FournisseurService;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository fournisseurRepository;
    private final OperationService operationService;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository, OperationService operationService) {
        this.fournisseurRepository = fournisseurRepository;
        this.operationService = operationService;
    }

    // ----------------------------------------------------- //
    // -------------------- FOURNISSEUR -------------------- //
    // ----------------------------------------------------- //

    @Override
    public Fournisseur getFournisseurById(long idFournisseur) {
        return fournisseurRepository.findById(idFournisseur).orElse(new Fournisseur());
    }

    @Override
    public Fournisseur getFournisseurByNom(String nomFournisseur) {
        Fournisseur fournisseur = fournisseurRepository.findByNom(nomFournisseur);
        if(fournisseur != null) {
            return fournisseur;
        } else {
            return new Fournisseur();
        }
    }

    @Override
    public List<Fournisseur> getAllFournisseur() {
        return fournisseurRepository.findAll();
    }

    @Override
    public List<Fournisseur> getAllFournisseurActif() {
        return fournisseurRepository.findAllByActif(true);
    }

    @Override
    public List<Fournisseur> getAllFournisseurFromListFournisseurId(List<Long> listIdFournisseur) {
        List<Fournisseur> listFournisseur = new ArrayList<Fournisseur>();
        for (long idFournisseur : listIdFournisseur) {
            Fournisseur fournisseur = getFournisseurById(idFournisseur);
            if (fournisseur.getId() != 0) {
                listFournisseur.add(fournisseur);
            }
        }
        return listFournisseur;
    }

    // --------------------------------------------------------- //
    // -------------------- FOURNISSEUR_DTO -------------------- //
    // --------------------------------------------------------- //

    @Override
    public FournisseurDto getFournisseurDtoById(long idFournisseur) {
        Fournisseur fournisseur = getFournisseurById(idFournisseur);
        if(fournisseur.getId() != 0) {
            return new FournisseurDto(fournisseur);
        } else {
            return new FournisseurDto();
        }
    }

    @Override
    public FournisseurDto getFournisseurDtoByNom(String nomFournisseur) {
        Fournisseur fournisseur = getFournisseurByNom(nomFournisseur);
        if(fournisseur.getId() != 0) {
            return new FournisseurDto(fournisseur);
        } else {
            return new FournisseurDto();
        }
    }

    @Override
    public List<FournisseurDto> getAllFournisseurDto() {
        List<Fournisseur> listFournisseur =  getAllFournisseur();
        List<FournisseurDto> listFournisseurDto = new ArrayList<FournisseurDto>();
        for(Fournisseur f: listFournisseur) {
            listFournisseurDto.add(new FournisseurDto(f));
        }
        return listFournisseurDto;
    }

    @Override
    public List<FournisseurDto> getAllFournisseurDtoActif() {
        List<Fournisseur> listFournisseurActif = getAllFournisseurActif();
        List<FournisseurDto> listFournisseurDto = new ArrayList<FournisseurDto>();
        for(Fournisseur f: listFournisseurActif) {
            listFournisseurDto.add(new FournisseurDto(f));
        }
        return listFournisseurDto;
    }

    @Override
    public List<FournisseurDto> getAllFournisseurDtoFromListFournisseurId(List<Long> listIdFournisseur) {
        List<FournisseurDto> listFournisseurDto = new ArrayList<FournisseurDto>();
        List<Fournisseur> listFournisseur = getAllFournisseurFromListFournisseurId(listIdFournisseur);
        for(Fournisseur f: listFournisseur) {
            listFournisseurDto.add(new FournisseurDto(f));
        }
        return listFournisseurDto;
    }

    @Override
    public FournisseurDto deleteFournisseur(long idFournisseur) {
        Fournisseur newFournisseur = fournisseurRepository.findById(idFournisseur).orElse(null);
        if(newFournisseur != null) {
            newFournisseur.setActif(false);
            fournisseurRepository.save(newFournisseur);
            return new FournisseurDto(newFournisseur);
        } else {
            return new FournisseurDto();
        }
    }

    @Override
    public FournisseurDto getEmptyFournisseurDto() {
        return new FournisseurDto();
    }

    @Override
    public FournisseurDto createFournisseur(FournisseurDto fournisseurDto) {
        Fournisseur fournisseur = new Fournisseur();

        if(fournisseurDto.getId() == 0) {
            fournisseur = new Fournisseur(fournisseurDto.getNom(), fournisseurDto.getIdentifiant());
            fournisseurRepository.save(fournisseur);
        }

        return new FournisseurDto(fournisseur);
    }

    @Override
    public FournisseurDto updateFournisseur(FournisseurDto fournisseurDto) {
        Fournisseur fournisseur = new Fournisseur();

        if(fournisseurDto.getId() != 0) {
            List<Fournisseur> listFournisseur = fournisseurRepository.findAllByIdentifiant(fournisseurDto.getIdentifiant());
            for(Fournisseur f: listFournisseur) {
                f.setActif(false);
            }
            fournisseur = new Fournisseur(fournisseurDto);
            listFournisseur.add(fournisseur);
            fournisseurRepository.saveAll(listFournisseur);
        }

        return new FournisseurDto(fournisseur);
    }

}
