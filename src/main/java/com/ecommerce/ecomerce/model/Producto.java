package com.ecommerce.ecomerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "nombre_producto", nullable = false, length = 255)
    private String nombreProducto;

    @Column(name = "descripcion_producto", columnDefinition = "TEXT")
    private String descripcionProducto;

    @Column(name = "fecha_agregado", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAgregado;
    // Relación con Categoria (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    // Relación con Variante (Uno a Muchos)
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Variante> variantes;

    // Relación con Descuento (Uno a Muchos)
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Descuento> descuentos;
}
