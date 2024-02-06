package com.testa.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testa.back.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
    
    Operation findByNom(String nomOperation);
    List<Operation> findAllByActif(boolean actif);
    
}
