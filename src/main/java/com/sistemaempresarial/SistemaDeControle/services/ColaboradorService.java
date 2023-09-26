package com.sistemaempresarial.SistemaDeControle.services;

import com.sistemaempresarial.SistemaDeControle.models.Colaborador;
import com.sistemaempresarial.SistemaDeControle.repositories.ColaboradorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColaboradorService {
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public Colaborador findById(Long id){
        Optional<Colaborador> colaborador = this.colaboradorRepository.findById(id);
        return colaborador.orElseThrow(()-> new RuntimeException(
            "Colaborador não encontrado! Id:" + id + "Tipo:" + Colaborador.class.getName()
        ));
    }

    @Transactional
    public Colaborador create(Colaborador obj){
        obj.setId(null);
        obj = this.colaboradorRepository.save(obj);
        return obj;
    }

    @Transactional
    public Colaborador update(Colaborador obj){
        Colaborador newobj = findById(obj.getId());
        newobj.setPassword(obj.getPassword());
        return this.colaboradorRepository.save(newobj);
    }

    public void delete(Long id){
        findById(id);
        try{
            this.colaboradorRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Não há entidades relacionadas");
        }
    }

}
