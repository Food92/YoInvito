package com.YoInvito.YoInvito.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="restaurant")
public class Restaurant {
    /**
     * @Id -> Se define como la llave primaria del elemento
     * @GeneratedValue -> Nos permite generar un id de la primary key de forma automática
     * @Column -> Nos permite modificar la propiedad de un campo, por ejemplo que no se nulo
     * que tenga un valor único o como se llamará en la BD.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_restaurant")
    private Long idRestaurant;

    @Column(nullable = false)
    @NotBlank(message = "El campo de nombre del restaurante no puede ser vacio")
    private String nombreRestaurant;

    @Column(nullable = false)
    @NotBlank(message = "El campo de direccion no puede ser vacio")
    private String direccion;

    @Column(nullable = false)
    @NotBlank(message = "El campo de telefono no puede ser vacio")
    private String telephone;

    @NotBlank(message = "El campo de descripcion no debe ser vacio")
    @NotNull(message = "El campo descripion no puede ser  nullo")
    private String categoria;

    @NotBlank(message = "El campo de correo no puede ser vacio")
    @Column(nullable = false, unique = true)
    @Email(message = "El correo tiene que tener el formato de correo")
    private String correo;

    @Embedded
    Audit audit= new Audit();


}
