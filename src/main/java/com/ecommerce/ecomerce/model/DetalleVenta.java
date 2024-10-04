package com.ecommerce.ecomerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private float precioUnitario;

    // Relación con Venta (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

    // Relación con Variante (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "id_variante", nullable = false)
    private Variante variante;
}
