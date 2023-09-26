package com.sistemaempresarial.SistemaDeControle.services;

import com.sistemaempresarial.SistemaDeControle.models.Colaborador;
import com.sistemaempresarial.SistemaDeControle.models.Fornecedor;
import com.sistemaempresarial.SistemaDeControle.repositories.FornecedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;



@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor findById(Long id) {
        Optional<Fornecedor> fornecedor = this.fornecedorRepository.findById(id);
        return fornecedor.orElseThrow(() -> new RuntimeException("Fornecedor não encontrado! Id:" + id + "Tipo:" + Fornecedor.class.getName()
        ));
    }

    @Transactional
    public Fornecedor create(Fornecedor obj) {
        obj.setId(null);
        obj = this.fornecedorRepository.save(obj);
        return obj;
    }

    @Transactional
    public Fornecedor update(Fornecedor obj) {
        Fornecedor newobj = findById(obj.getId());
        newobj.setEndereco(obj.getEndereco());
        return this.fornecedorRepository.save(newobj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.fornecedorRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não há entidades relacionadas");
        }


    }
}
