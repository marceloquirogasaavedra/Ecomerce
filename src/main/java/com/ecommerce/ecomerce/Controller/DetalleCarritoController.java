package com.ecommerce.ecomerce.Controller;

import com.ecommerce.ecomerce.model.DetalleCarrito;
import com.ecommerce.ecomerce.service.DetalleCarritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("detallecarrito")
@RequiredArgsConstructor
public class DetalleCarritoController {

    private final DetalleCarritoService detalleCarritoService;

    @GetMapping
    public List<DetalleCarrito> getAllDetallesCarrito() {
        return detalleCarritoService.getAllDetallesCarrito();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCarrito> getDetalleCarritoById(@PathVariable int id) {
        Optional<DetalleCarrito> detalleCarrito = detalleCarritoService.getDetalleCarritoById(id);
        return detalleCarrito.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DetalleCarrito createDetalleCarrito(@RequestBody DetalleCarrito detalleCarrito) {
        return detalleCarritoService.saveDetalleCarrito(detalleCarrito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleCarrito(@PathVariable int id) {
        detalleCarritoService.deleteDetalleCarrito(id);
        return ResponseEntity.ok().build();
    }
}
