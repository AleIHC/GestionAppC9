package com.generation.gestionapp.service;

import com.generation.gestionapp.model.Departamento;
import com.generation.gestionapp.model.Departamento ;
import com.generation.gestionapp.repository.DepartamentoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {

    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento guardarDepartamento(Departamento departamentoParaGuardar) {

        Boolean departamentoExiste = departamentoRepository.existsById(departamentoParaGuardar.getDepartamentoId());

        if (!(departamentoExiste)) {
            return departamentoRepository.save(departamentoParaGuardar);
        } else  {
            return null;
        }

    }

    @Override
    public void eliminarDepartamentoPorId(Long id) {
        departamentoRepository.deleteById(id);
    }

    @Override
    public Departamento  editarDepartamentoPorId(Departamento  DepartamentoParaEditar, Long id) {

        Departamento   departamentoSeleccionado = departamentoRepository.findById(id).get();
        departamentoSeleccionado.setDepartamentoId(id);

        return departamentoRepository.save(departamentoSeleccionado);
    }
}
