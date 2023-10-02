package com.sistemaempresarial.SistemaDeControle.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "colaborador")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Colaborador {
    @Id
    @Column(name="id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 200,nullable = false)
    @Size(min=1 ,max = 200)
    @NotBlank
    private String username;

    @Column(name ="password", length = 60, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min=8, max=60)
    @NotBlank
    private String password;

    @Column(name = "salario", length = 125, nullable = false)
    @Size(min = 1, max = 125)
    private String salario;

    @Column(name="email", length = 250, nullable = false, unique = true)
    @Size(min = 1, max=250)
    @NotBlank
    private String email;

    @Column(name="numero", length = 125,nullable = false)
    @Size(min=11,max=125)
    @NotBlank
    private String numero;

    @Column(name="cargo", length = 125, nullable = false)
    @Size(min = 1, max=125)
    @NotBlank
    private String cargo;

    @Column(name = "idade", length=5, nullable = false)
    @Size(min = 1, max = 5)
    @NotBlank
    private String idade;

    @Column(name="endereço", length = 250, nullable = false)
    @Size(min = 1, max=250)
    @NotBlank
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "corporação_id", nullable = false, updatable = false)
    private Corporacão corporacão;


}
