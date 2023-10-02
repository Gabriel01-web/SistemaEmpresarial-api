package com.sistemaempresarial.SistemaDeControle.repositories;

import com.sistemaempresarial.SistemaDeControle.models.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador,Long> {

    List<Colaborador> findByCorporacao_Id(Long id);

}
