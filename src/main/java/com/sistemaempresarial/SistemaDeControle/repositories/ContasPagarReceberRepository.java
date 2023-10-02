package com.sistemaempresarial.SistemaDeControle.repositories;

import com.sistemaempresarial.SistemaDeControle.models.ContasPagarReceber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContasPagarReceberRepository  extends JpaRepository<ContasPagarReceber, Long> {

    List<ContasPagarReceber> findByCorporacao_Id(Long id);

}
