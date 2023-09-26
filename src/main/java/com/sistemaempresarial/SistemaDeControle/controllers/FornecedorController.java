package com.sistemaempresarial.SistemaDeControle.controllers;


import com.sistemaempresarial.SistemaDeControle.models.Fornecedor;
import com.sistemaempresarial.SistemaDeControle.services.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/fornecedor")
@Validated
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id){
        Fornecedor obj = this.fornecedorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Fornecedor obj){
        this.fornecedorService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Fornecedor obj, @PathVariable Long id){
        obj.setId(id);
        this.fornecedorService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }
 }
