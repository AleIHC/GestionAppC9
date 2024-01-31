package com.generation.gestionapp.service;

import com.generation.gestionapp.model.Tarea;
import com.generation.gestionapp.repository.TareaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TareaServiceImpl implements TareaService{

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> obtenerListaTareas() {
        return tareaRepository.findAll();
    }
}
