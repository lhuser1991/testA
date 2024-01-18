package com.testa.back.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Etat;
import com.testa.back.model.Fournisseur;
import com.testa.back.model.modelDto.FournisseurDto;
import com.testa.back.repository.FournisseurRepository;
import com.testa.back.service.FournisseurService;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository fournisseurRepository;
    private final EtatServiceImpl etatServiceImpl;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository, EtatServiceImpl etatServiceImpl) {
        this.fournisseurRepository = fournisseurRepository;
        this.etatServiceImpl = etatServiceImpl;
    }

    @Override
    public FournisseurDto getFournisseurById(long idFournisseur) {
        Fournisseur fournisseur = fournisseurRepository.findById(idFournisseur).orElse(null);
        if(fournisseur != null) {
            return new FournisseurDto(fournisseur);
        } else {
            return new FournisseurDto();
        }
    }

    @Override
    public FournisseurDto getFournisseurByNom(String nomFourrnisseur) {
        Fournisseur fournisseur = fournisseurRepository.findByNom(nomFourrnisseur);
        if(fournisseur != null) {
            return new FournisseurDto(fournisseur);
        } else {
            return new FournisseurDto();
        }
    }

    @Override
    public List<FournisseurDto> getAllFournisseur() {
        List<Fournisseur> listFournisseur =  fournisseurRepository.findAll();
        List<FournisseurDto> listFournisseurDto = new ArrayList<FournisseurDto>();
        for(Fournisseur f: listFournisseur) {
            listFournisseurDto.add(new FournisseurDto(f));
        }
        return listFournisseurDto;
    }

    @Override
    public List<FournisseurDto> getAllFournisseurActif() {
        List<Fournisseur> listFournisseurActif = fournisseurRepository.findAllByActif(true);
        List<FournisseurDto> listFournisseurDto = new ArrayList<FournisseurDto>();
        for(Fournisseur f: listFournisseurActif) {
            listFournisseurDto.add(new FournisseurDto(f));
        }
        return listFournisseurDto;
    }

    @Override
    public List<FournisseurDto> getAllFournisseurFromListFournisseurId(List<Long> listIdFournisseur) {
        List<FournisseurDto> listFournisseurDto = new ArrayList<FournisseurDto>();
        for (long idFournisseur : listIdFournisseur) {
            FournisseurDto fournisseurDto = getFournisseurById(idFournisseur);
            if (fournisseurDto.getId() != 0) {
                listFournisseurDto.add(fournisseurDto);
            }
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
    public FournisseurDto getEmptyFournisseur() {
        return new FournisseurDto();
    }

    @Override
    public FournisseurDto createFournisseur(FournisseurDto fournisseurDto) {

        Fournisseur fournisseur = new Fournisseur();
        if(fournisseurDto.getId() == 0) {
            // creation
            fournisseur = new Fournisseur(fournisseurDto.getNom());
        } else {
            // modification
            fournisseur = new Fournisseur(fournisseurDto);
        }
        Etat etat = etatServiceImpl.getEtatById(fournisseurDto.getIdEtat());
        if(etat.getId() != 0) {
            fournisseur.setEtat(etat);
            fournisseurRepository.save(fournisseur);
        }

        return new FournisseurDto(fournisseur);
    }

}
