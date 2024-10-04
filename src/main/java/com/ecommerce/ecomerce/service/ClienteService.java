package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Cliente;
import com.ecommerce.ecomerce.repository.ClienteRepository;
import com.ecommerce.ecomerce.repository.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final VentaRepository ventaRepository;
    // Obtener todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Guardar un cliente
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Obtener un cliente por ID
    public Optional<Cliente> getClienteById(int id) {
        return clienteRepository.findById(id);
    }

    // Eliminar un cliente por ID
    public void deleteCliente(int id) {
            clienteRepository.deleteById(id);

        }
}

