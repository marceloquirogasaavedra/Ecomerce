package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Pedido;
import com.ecommerce.ecomerce.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> getPedidoById(int id) {
        return pedidoRepository.findById(id);
    }

    public void deletePedido(int id) {
        pedidoRepository.deleteById(id);
    }
}
