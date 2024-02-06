package com.testa.back.service.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.testa.back.model.Operation;
import com.testa.back.repository.OperationRepository;
import com.testa.back.service.OperationService;

@Service
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;

    public OperationServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public Operation getOperationById(long idOperation) {
        Operation operation = operationRepository.findById(idOperation).orElse(null);
        if(operation != null) {
            return operation;
        } else {
            return new Operation();
        }
    }

    @Override
    public Operation getOperationByNom(String nomOperation) {
        Operation operation = operationRepository.findByNom(nomOperation);
        if(operation != null) {
            return operation;
        } else {
            return new Operation();
        }
    }

    @Override
    public List<Operation> getAllOperation() {
        return operationRepository.findAll();
    }

    @Override
    public List<Operation> getAllOperationActif() {
        return operationRepository.findAllByActif(true);
    }

    @Override
    public Operation deleteOperation(long idOperation) {
        Operation operation = getOperationById(idOperation);
        if(operation.getId() != 0) {
            operation.setActif(false);
            return operationRepository.save(operation);
        } else {
            return operation;
        }
    }

    @Override
    public Operation createOperation(Operation operation) {
        if(Objects.nonNull(operation)) {
            operation.setActif(true);
            return operationRepository.save(operation);
        } else {
            return new Operation();
        }
    }

    @Override
    public Operation getEmptyOperation() {
        return new Operation();
    }
    
}
