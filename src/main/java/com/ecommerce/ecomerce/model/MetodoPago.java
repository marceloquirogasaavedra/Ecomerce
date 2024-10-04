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
@Table(name = "metodo_pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_metodo_pago")
    private int idMetodoPago;

    @Column(name = "nombre_metodo", nullable = false, length = 50)
    private String nombreMetodo;

    // Relación con Venta (Uno a Muchos)
    @OneToMany(mappedBy = "metodoPago", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Venta> ventas;
}
