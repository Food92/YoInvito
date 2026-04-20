package com.YoInvito.YoInvito.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @NotBlank(message = "El campo de nombre del producto no uede ser vacio")
    @Column(nullable = false)
    private String nombreProducto;

    @NotBlank(message = "Este campo no puedes ser vacio")
    @Column(nullable = false)
    private String descripcion;

    @NotNull(message = "El campo precio no puede ser vacio")
    @Column(nullable = false)
    @Positive(message = "El precio debe ser mayor que cero")
    private Double precio;

    @ManyToOne
    private Restaurant restaurant;

    @Embedded
    Audit audit= new Audit();

}
