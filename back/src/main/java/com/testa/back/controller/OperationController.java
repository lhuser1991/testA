package com.testa.back.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testa.back.model.Operation;
import com.testa.back.service.OperationService;

@RestController
@RequestMapping("testa/operation/")
@CrossOrigin(origins = "http://localhost:4200")
public class OperationController {
    
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    // ---------- GETMAPPING ---------- //

    @GetMapping("id/{idOperation}")
    public ResponseEntity<Operation> getOperationById(@PathVariable long idOperation) {
        return ResponseEntity.ok(operationService.getOperationById(idOperation));
    }

    @GetMapping("nom/{nomOperation}")
    public ResponseEntity<Operation> getOperationByNom(@PathVariable String nomOperation) {
        return ResponseEntity.ok(operationService.getOperationByNom(nomOperation));
    }

    @GetMapping("list")
    public ResponseEntity<List<Operation>> getAllOperation() {
        return ResponseEntity.ok(operationService.getAllOperation());
    }

    @GetMapping("list/actif")
    public ResponseEntity<List<Operation>> getAllOperationActif() {
        return ResponseEntity.ok(operationService.getAllOperationActif());
    }

    @GetMapping("emptyOperation")
    public ResponseEntity<Operation> getEmptyOperation() {
        return ResponseEntity.ok(operationService.getEmptyOperation());
    }

    @GetMapping("deleteOperation/{idOperation}")
    public ResponseEntity<Operation> deleteOperation(@PathVariable long idOperation) {
        return ResponseEntity.ok(operationService.deleteOperation(idOperation));
    }

    // ---------- POSTMAPPING ---------- //

    @PostMapping("createOperation")
    public ResponseEntity<Operation> createOperation(@RequestBody Operation operation) {
        return ResponseEntity.ok(operationService.createOperation(operation));
    }
}
