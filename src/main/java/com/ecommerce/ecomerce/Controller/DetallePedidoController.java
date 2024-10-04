package com.ecommerce.ecomerce.Controller;

import com.ecommerce.ecomerce.model.DetallePedido;
import com.ecommerce.ecomerce.service.DetallePedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("detallepedido")
@RequiredArgsConstructor
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    @GetMapping
    public List<DetallePedido> getAllDetallesPedido() {
        return detallePedidoService.getAllDetallesPedido();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> getDetallePedidoById(@PathVariable int id) {
        Optional<DetallePedido> detallePedido = detallePedidoService.getDetallePedidoById(id);
        return detallePedido.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DetallePedido createDetallePedido(@RequestBody DetallePedido detallePedido) {
        return detallePedidoService.saveDetallePedido(detallePedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetallePedido(@PathVariable int id) {
        detallePedidoService.deleteDetallePedido(id);
        return ResponseEntity.ok().build();
    }
}
