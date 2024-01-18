package com.testa.back.service;

import java.util.List;

import com.testa.back.model.modelDto.FournisseurDto;

public interface FournisseurService {
    
    FournisseurDto getFournisseurById(long idFournisseur);
    FournisseurDto getFournisseurByNom(String nomFourrnisseur);
    List<FournisseurDto> getAllFournisseur();
    List<FournisseurDto> getAllFournisseurActif();
    List<FournisseurDto> getAllFournisseurFromListFournisseurId(List<Long> listIdFournisseur);
    FournisseurDto deleteFournisseur(long idFournisseur);
    FournisseurDto getEmptyFournisseur();
    FournisseurDto createFournisseur(FournisseurDto fournisseurDto);
}
