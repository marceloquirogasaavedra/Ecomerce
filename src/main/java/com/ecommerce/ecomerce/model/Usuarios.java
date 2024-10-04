package com.ecommerce.ecomerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.io.Serializable;

@Entity //la clase es una entidad
@Data // alamacena y genera de manera automatica los getters y setters
@Table (name = "usuarios") // dar nombre específico a la tabla

public class Usuarios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // las tuplas ingresadas sean autoincrementales
    private Long id;
    @Column(unique = true)
    private String username;
    @Email
    private String correo;
    private String password;

    @ManyToOne //relación de muchos a uno
    @JoinColumn(name = "id_rol")
    private Rol id_rol;

}