package com.sistemaempresarial.SistemaDeControle.services;

import com.sistemaempresarial.SistemaDeControle.models.ContasPagarReceber;
import com.sistemaempresarial.SistemaDeControle.models.Fornecedor;
import com.sistemaempresarial.SistemaDeControle.repositories.ContasPagarReceberRepository;
import com.sistemaempresarial.SistemaDeControle.repositories.FornecedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContasPagarReceberService {
    @Autowired
    private ContasPagarReceberRepository contasPagarReceberRepository;

    public ContasPagarReceber findById(Long id) {
        Optional<ContasPagarReceber> contasPagarReceber = this.contasPagarReceberRepository.findById(id);
        return contasPagarReceber.orElseThrow(() -> new RuntimeException("Conta não encontrado! Id:" + id + "Tipo:" + ContasPagarReceber.class.getName()
        ));
    }

    @Transactional
    public ContasPagarReceber create(ContasPagarReceber obj) {
        obj.setId(null);
        obj = this.contasPagarReceberRepository.save(obj);
        return obj;
    }

    @Transactional
    public ContasPagarReceber update(ContasPagarReceber obj) {
        ContasPagarReceber newobj = findById(obj.getId());
        newobj.setContaapagar(obj.getContaapagar());
        newobj.setContaareceber(obj.getContaareceber());
        newobj.setNomedaconta(obj.getNomedaconta());
        return this.contasPagarReceberRepository.save(newobj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.contasPagarReceberRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não há entidades relacionadas");
        }


    }
}
