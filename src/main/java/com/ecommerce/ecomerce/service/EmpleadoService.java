package com.ecommerce.ecomerce.service;

import com.ecommerce.ecomerce.model.Empleado;
import com.ecommerce.ecomerce.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Optional<Empleado> getEmpleadoById(int id) {
        return empleadoRepository.findById(id);
    }

    public void deleteEmpleado(int id) {
        empleadoRepository.deleteById(id);
    }
}
