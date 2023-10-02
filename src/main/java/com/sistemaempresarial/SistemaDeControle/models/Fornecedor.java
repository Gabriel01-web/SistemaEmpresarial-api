package com.sistemaempresarial.SistemaDeControle.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "fornecedor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fornecedor {
    @Id
    @Column(name ="id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200,nullable = false)
    @Size(min=1, max= 200)
    @NotBlank
    private String name;

    @Column(name = "pagamento", length = 125, nullable = false)
    @Size(min = 1, max = 125)
    @NotBlank
    private String pagamento;

    @Column(name = "email", length = 250, nullable = false, unique = true)
    @Size(min=1, max=250)
    @NotBlank
    private String email;

    @Column(name = "numero", length = 45, nullable = false, unique = true)
    @Size(min=11, max=45)
    @NotBlank
    private String numerodetelefone;

    @Column(name = "endereço", length =255, nullable = false, unique = true)
    @Size(min = 1, max = 255)
    @NotBlank
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "corporacao_id",nullable = false, updatable = false)
    private Corporacão corporacão;


}
