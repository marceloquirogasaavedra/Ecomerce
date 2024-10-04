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
@Table(name = "variante")
public class Variante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_variante")
    private int idVariante;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "talla", length = 5)
    private String talla;

    @Column(name = "material", length = 255)
    private String material;

    @Column(name = "precio_variante", nullable = false)
    private float precioVariante;

    @Column(name = "stock_variante", nullable = false)
    private int stockVariante;

    // Relación con Producto (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    // Relación con DetallePedido (Uno a Muchos)
    @OneToMany(mappedBy = "variante", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DetallePedido> detallesPedido;

    // Relación con Inventario (Uno a Muchos)
    @OneToMany(mappedBy = "variante", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Inventario> inventario;
}
