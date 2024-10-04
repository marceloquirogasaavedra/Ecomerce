package com.ecommerce.ecomerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    // Relación con Pedido (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    // Relación con Variante (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "id_variante", nullable = false)
    private Variante variante;
}
