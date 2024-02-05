package com.generation.gestionapp.service;

import com.generation.gestionapp.model.Cargo;
import com.generation.gestionapp.model.Tarea;
import com.generation.gestionapp.repository.CargoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;


    @Override
    public List<Cargo> listarCargos() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo guardarCargo(Cargo cargoParaGuardar) {
        Boolean cargoExiste = cargoRepository.existsById(cargoParaGuardar.getCargoId());

        if (!(cargoExiste)) {
            return cargoRepository.save(cargoParaGuardar);
        } else {
            return null;
        }

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
