package com.YoInvito.YoInvito.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cliente_id")
    private Long clienteId;


    @Column(unique = true, nullable = false)
    @NotBlank(message="El campo run no puede ser vacio")
    @Pattern(regexp = "\\d{1,8}-[dKk]", message = "El formato del rt tiene que ser xxxxxxx-x")
    private String run;

    @Column(nullable = false, name="nombre_completo")
    @NotBlank(message="El compo nombre no puede ser vacio")
    private String nombreCompleto;
}
