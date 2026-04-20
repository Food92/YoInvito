package com.YoInvito.YoInvito.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PededidoCreacionDTO {
    @NotNull(message = "El campo de hora de pedido no puede ser vacio")
    private LocalDate horaPedido;

    @NotNull(message = "El campo de precio no puede ser vacio")
    private Double precioPPedido;
}
