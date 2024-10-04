package com.ecommerce.ecomerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_inventario")
    private int id_inventario;

    @Column(name = "cantidad_disponible", nullable = false)
    private int cantidadDisponible;

    // Relación con Variante (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "id_variante", nullable = false)
    private Variante variante;
}
