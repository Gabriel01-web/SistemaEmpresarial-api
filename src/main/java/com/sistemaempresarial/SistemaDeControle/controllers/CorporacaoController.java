package com.sistemaempresarial.SistemaDeControle.controllers;

import com.sistemaempresarial.SistemaDeControle.models.Colaborador;
import com.sistemaempresarial.SistemaDeControle.models.Corporacão;
import com.sistemaempresarial.SistemaDeControle.services.CorporacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
@Validated
public class CorporacaoController {
    @Autowired
    private CorporacaoService corporacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Corporacão> findById(@PathVariable Long id){
        Corporacão obj = this.corporacaoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Corporacão obj){
        this.corporacaoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Corporacão obj,@PathVariable Long id){
        obj.setId(id);
        this.corporacaoService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.corporacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
