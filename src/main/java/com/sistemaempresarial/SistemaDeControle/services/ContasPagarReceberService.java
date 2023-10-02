package com.sistemaempresarial.SistemaDeControle.services;

import com.sistemaempresarial.SistemaDeControle.models.ContasPagarReceber;
import com.sistemaempresarial.SistemaDeControle.models.Corporacão;
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

    @Autowired
    private CorporacaoService corporacaoService;

    public ContasPagarReceber findById(Long id){
        Optional<ContasPagarReceber> contasPagarReceber = this.contasPagarReceberRepository.findById(id);
        return contasPagarReceber.orElseThrow(()-> new RuntimeException(
                "Conta não encontrado! Id:" + id + "Tipo:" + ContasPagarReceber.class.getName()));
    }

    @Transactional
    public ContasPagarReceber create(ContasPagarReceber obj){
        Corporacão corporacão = this.corporacaoService.findById(obj.getCorporacão().getId());
        obj.setId(null);
        obj.setCorporacão(corporacão);
        obj = this.contasPagarReceberRepository.save(obj);
        return obj;
    }

    @Transactional
    public ContasPagarReceber update(ContasPagarReceber obj){
        ContasPagarReceber newobj = findById(obj.getId());
        newobj.setNomedaconta(obj.getNomedaconta());
        newobj.setContaapagar(obj.getContaapagar());
        newobj.setContaareceber(obj.getContaareceber());
        return this.contasPagarReceberRepository.save(newobj);
    }

    public void delete(Long id){
        findById(id);
        try{
            this.contasPagarReceberRepository.deleteById(id);
        }catch(Exception e) {
            throw new RuntimeException("Não foi possivel deletar");
        }
    }

}
