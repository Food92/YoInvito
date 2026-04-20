package com.YoInvito.YoInvito.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "pedido")

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_restaurant")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles;

    @Column(nullable = false)
    private LocalDate fechaPedido;

    @Column(nullable = false)
    private String estado;

    private Double montoTotal;

    //Metodo para calcular el total
    public Double calcularMontoTotal(){
        if(detalles==null)
            return 0.0;
        return detalles.stream().mapToDouble(d-> d.getCantidad()*d.getPrecioUnitario()).sum();
    }

}
