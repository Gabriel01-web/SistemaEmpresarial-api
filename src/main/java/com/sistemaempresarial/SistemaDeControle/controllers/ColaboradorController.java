package com.sistemaempresarial.SistemaDeControle.controllers;

import com.sistemaempresarial.SistemaDeControle.models.Colaborador;
import com.sistemaempresarial.SistemaDeControle.services.ColaboradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/colaborador")
@Validated
public class ColaboradorController {
    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> findById(@PathVariable Long id){
        Colaborador obj = this.colaboradorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Colaborador obj){
        this.colaboradorService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Colaborador obj, @PathVariable Long id ){
        obj.setId(id);
        this.colaboradorService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.colaboradorService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
