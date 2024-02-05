package com.generation.gestionapp.service;

import com.generation.gestionapp.model.Tarea;
import com.generation.gestionapp.repository.TareaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TareaServiceImpl implements TareaService{

    private final TareaRepository tareaRepository;

    @Override
    public List<Tarea> obtenerListaTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea guardarTarea(Tarea tareaParaGuardar) {
        Boolean tareaExiste = tareaRepository.existsById(tareaParaGuardar.getTareaId());

        if (!(tareaExiste)) {
            return tareaRepository.save(tareaParaGuardar);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarTareaPorId(Long id) {
        tareaRepository.deleteById(id);
    }

    @Override
    public Tarea editarTareaPorId(Tarea tareaParaEditar, Long id) {

        Tarea tareaSeleccionada = tareaRepository.findById(id).get();
        tareaSeleccionada.setTareaId(id);

        return tareaRepository.save(tareaSeleccionada);
    }


}
