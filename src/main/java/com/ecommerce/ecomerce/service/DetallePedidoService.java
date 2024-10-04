package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.DetallePedido;
import com.ecommerce.ecomerce.repository.DetallePedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedido> getAllDetallesPedido() {
        return detallePedidoRepository.findAll();
    }

    public DetallePedido saveDetallePedido(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    public Optional<DetallePedido> getDetallePedidoById(int id) {
        return detallePedidoRepository.findById(id);
    }

    public void deleteDetallePedido(int id) {
        detallePedidoRepository.deleteById(id);
    }
}
