package com.testa.back.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testa.back.model.Etat;
import com.testa.back.repository.EtatRepository;
import com.testa.back.service.EtatService;

@Service
public class EtatServiceImpl implements EtatService {

    private final EtatRepository etatRepository;

    public EtatServiceImpl(EtatRepository etatRepository) {
        this.etatRepository = etatRepository;
    }

    @Override
    public Etat getEtatById(long idEtat) {
        Etat etat = etatRepository.findById(idEtat).orElse(null);
        if(etat != null) {
            return etat;
        } else {
            return new Etat();
        }
    }

    @Override
    public Etat getEtatByNom(String nomEtat) {
        Etat etat = etatRepository.findByNom(nomEtat);
        if(etat != null) {
            return etat;
        } else {
            return new Etat();
        }
    }

    @Override
    public List<Etat> getAllEtat() {
        return etatRepository.findAll();
    }

    @Override
    public List<Etat> getAllEtatActif() {
        return etatRepository.findAllByActif(true);
    }

    @Override
    public Etat deleteEtat(long idEtat) {
        Etat etat = getEtatById(idEtat);
        if(etat.getId() != 0) {
            etat.setActif(false);
            return etatRepository.save(etat);
        } else {
            return etat;
        }
    }

    @Override
    public Etat createEtat(Etat etat) {
        if(etat.getId() == 0) {
            // creation
            Etat newEtat = new Etat(etat.getNom());
            return etatRepository.save(newEtat);
        } else {
            // modification
            return etatRepository.save(etat);
        }
    }

    @Override
    public Etat getEmptyEtat() {
        return new Etat();
    }
    
}
