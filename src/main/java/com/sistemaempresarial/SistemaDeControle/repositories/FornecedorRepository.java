package com.sistemaempresarial.SistemaDeControle.repositories;

import com.sistemaempresarial.SistemaDeControle.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long> {

    List<Fornecedor> findByCorporacao_Id(Long id);
}
