package com.sistemaempresarial.SistemaDeControle.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contaspagarreceber")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContasPagarReceber {
    @Id
    @Column(name="id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nomedaconta",length = 255, nullable = false)
    @Size(min = 1, max = 255)
    @NotBlank
    private String nomedaconta;


    @Column(name = "contasareceber",length = 53, nullable = false)
    @Size(min = 1, max=53)
    @NotNull
    private double contaareceber;

    @Column(name = "contasapagar",length = 53, nullable = false)
    @Size(min = 1, max=53)
    @NotNull
    private double contaapagar;

}
