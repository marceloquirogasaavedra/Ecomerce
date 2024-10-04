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
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_venta")
    private int idVenta;

    @Column(name = "fecha_venta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;

    @Column(name = "monto_total", nullable = false)
    private float montoTotal;

    // Relación con Cliente (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    // Relación con MetodoPago (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    // Relación con DetalleVenta (Uno a Muchos)
    @OneToMany(mappedBy = "venta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DetalleVenta> detallesVenta;
}
