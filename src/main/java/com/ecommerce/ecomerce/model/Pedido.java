package com.ecommerce.ecomerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pedido")
    private int idPedido;

    @Column(name = "fecha_pedido", nullable = false)
    private String fechaPedido;

    @Column(name = "monto_total", nullable = false)
    private float montoTotal;

    // Relación con Cliente (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    // Relación con DetallePedido (Uno a Muchos)
    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DetallePedido> detallesPedido;
}
