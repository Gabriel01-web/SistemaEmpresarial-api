package com.sistemaempresarial.SistemaDeControle.controllers;



import com.sistemaempresarial.SistemaDeControle.models.ContasPagarReceber;
import com.sistemaempresarial.SistemaDeControle.services.ContasPagarReceberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Validated
@RequestMapping("/Contas")
public class ContasPagarReceberController {
    @Autowired
    private ContasPagarReceberService contasPagarReceberService;

    @GetMapping("/{id}")
    public ResponseEntity<ContasPagarReceber> findById(@PathVariable Long id){
        ContasPagarReceber obj = this.contasPagarReceberService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    @Validated
    public ResponseEntity<Void> create(@Valid @RequestBody ContasPagarReceber obj){
        this.contasPagarReceberService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<Void> update(@Valid @RequestBody ContasPagarReceber obj, @PathVariable Long id){
        obj.setId(id);
        this.contasPagarReceberService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.contasPagarReceberService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
