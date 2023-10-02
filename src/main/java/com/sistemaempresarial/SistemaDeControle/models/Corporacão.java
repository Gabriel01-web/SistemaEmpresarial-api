package com.sistemaempresarial.SistemaDeControle.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "corporação")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Corporacão {
    public interface CreateEmpresa {}
    public interface UpdateEmpresa {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 255, nullable = false, unique = true)
    @NotBlank(groups = {CreateEmpresa.class, UpdateEmpresa.class})
    @Size(groups = {CreateEmpresa.class,UpdateEmpresa.class},min = 1, max = 255)
    private String nome;

    @Column(name = "nomefantasia", length = 255, nullable = false)
    @NotBlank(groups = {CreateEmpresa.class, UpdateEmpresa.class})
    @Size(groups = {CreateEmpresa.class,UpdateEmpresa.class},min = 1, max=255)
    private String nomeFantasia;

    @OneToMany(mappedBy = "corporacão")
    private List<Colaborador> colaboradorList = new ArrayList<>();

    @OneToMany(mappedBy = "corporacão")
    private List<ContasPagarReceber> contasPagarReceberList = new ArrayList<>();

    @OneToMany(mappedBy = "corporacão")
    private List<Fornecedor> fornecedorList = new ArrayList<>();





}
