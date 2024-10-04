package com.ecommerce.ecomerce.Controller;

import com.ecommerce.ecomerce.model.Carrito;
import com.ecommerce.ecomerce.service.CarritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrito")
@RequiredArgsConstructor
public class CarritoController {

    private final CarritoService carritoService;

    @GetMapping
    public List<Carrito> getAllCarritos() {
        return carritoService.getAllCarritos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> getCarritoById(@PathVariable int id) {
        Optional<Carrito> carrito = carritoService.getCarritoById(id);
        return carrito.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carrito createCarrito(@RequestBody Carrito carrito) {
        return carritoService.saveCarrito(carrito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrito(@PathVariable int id) {
        carritoService.deleteCarrito(id);
        return ResponseEntity.ok().build();
    }
}
