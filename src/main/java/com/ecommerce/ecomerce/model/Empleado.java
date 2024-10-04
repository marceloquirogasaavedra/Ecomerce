package com.ecommerce.ecomerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_empleado")
    private int idEmpleado;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "puesto", nullable = false, length = 100)
    private String puesto;

    // Relación con Sucursal (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;
}
