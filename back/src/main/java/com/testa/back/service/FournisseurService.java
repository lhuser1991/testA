package com.testa.back.service;

import java.util.List;

import com.testa.back.model.Fournisseur;

public interface FournisseurService {
    
    Fournisseur getFournisseurById(long idFournisseur);
    Fournisseur getFournisseurByNom(String nomFourrnisseur);
    List<Fournisseur> getAllFournisseur();
    List<Fournisseur> getAllFournisseurActif();
    List<Fournisseur> getAllFournisseurFromListFournisseurId(List<Long> listIdFournisseur);
    Fournisseur createFournisseur(Fournisseur fournisseur);
}
