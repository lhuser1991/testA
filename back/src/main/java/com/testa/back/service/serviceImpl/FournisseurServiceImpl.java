package com.testa.back.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Fournisseur;
import com.testa.back.repository.FournisseurRepository;
import com.testa.back.service.FournisseurService;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository fournisseurRepository;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public Fournisseur getFournisseurById(long idFournisseur) {
        return fournisseurRepository.findById(idFournisseur).orElse(null);
    }

    @Override
    public Fournisseur getFournisseurByNom(String nomFourrnisseur) {
        Fournisseur fournisseur = fournisseurRepository.findByNom(nomFourrnisseur);
        if (fournisseur == null) {
            return null;
        } else {
            return fournisseurRepository.findByNom(nomFourrnisseur);
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
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        for (long idFournisseur : listIdFournisseur) {
            Fournisseur fournisseur = getFournisseurById(idFournisseur);
            if (fournisseur != null) {
                listFournisseurs.add(fournisseur);
            }
        }
        return listFournisseurs;
    }

    @Override
    public Fournisseur createFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

}
