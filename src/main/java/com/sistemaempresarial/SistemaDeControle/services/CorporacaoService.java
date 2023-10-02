package com.sistemaempresarial.SistemaDeControle.services;

import com.sistemaempresarial.SistemaDeControle.models.Colaborador;
import com.sistemaempresarial.SistemaDeControle.models.Corporacão;
import com.sistemaempresarial.SistemaDeControle.repositories.CorporcaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CorporacaoService {

    @Autowired
    private CorporcaoRepository corporcaoRepository;

    public Corporacão findById(Long id){
        Optional<Corporacão> corporacão = this.corporcaoRepository.findById(id);
        return corporacão.orElseThrow(()-> new RuntimeException(
                "Corporação não encontrado! Id:" + id + "Tipo:" + Corporacão.class.getName()
        ));
    }

    @Transactional
    public Corporacão create(Corporacão obj){
        obj.setId(null);
        obj = this.corporcaoRepository.save(obj);
        return obj;
    }

    @Transactional
    public Corporacão update(Corporacão obj){
        Corporacão newobj = findById(obj.getId());
        newobj.setNome(obj.getNome());
        return this.corporcaoRepository.save(newobj);
    }

    public void delete(Long id){
        findById(id);
        try{
            this.corporcaoRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Não há entidades relacionadas");
        }
    }

}
