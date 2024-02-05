package com.generation.gestionapp.service;

import com.generation.gestionapp.dto.CargoDTO;
import com.generation.gestionapp.model.Cargo;
import com.generation.gestionapp.model.Empleado;
import com.generation.gestionapp.model.Tarea;
import com.generation.gestionapp.repository.CargoRepository;
import com.generation.gestionapp.repository.EmpleadoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;

    private final EmpleadoRepository empleadoRepository;


    @Override
    public List<Cargo> listarCargos() {
        return cargoRepository.findAll();
    }

    @Override
    public CargoDTO guardarCargo(CargoDTO cargoParaGuardar) {
        /*

        Empleado empleadoSeleccionado = empleadoRepository.
                findByCorreoEmpleado(cargoParaGuardar.getEmailEmpleado());

        Boolean empleadoExiste = (empleadoSeleccionado != null);

        if (empleadoExiste) {
            /*
            Cargo cargoEmpleado = cargoRepository.
                    findByNombreCargo(cargoParaGuardar.getNombreCargo());

            empleadoSeleccionado.setCargoEmpleado(cargoEmpleado);
            empleadoRepository.save(empleadoSeleccionado);
            return cargoParaGuardar;
        } else {
            return null;
        }
*/ return null;
    }

    @Override
    public void eliminarCargoPorId(Long id) {
        cargoRepository.deleteById(id);
    }

    @Override
    public Cargo editarCargoPorId(Cargo cargoParaEditar, Long id) {

        Cargo cargoSeleccionado = cargoRepository.findById(id).get();
        cargoSeleccionado.setCargoId(id);

        return cargoRepository.save(cargoSeleccionado);
    }
}
