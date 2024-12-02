package com.grupo7.testjwt.service;

import com.grupo7.testjwt.entity.Tarea;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TareaService {
    public List<Tarea> findAll(Pageable page);
    public List<Tarea> findAll();
    public List<Tarea> findByUsuario(String usuario);
    public Tarea save(Tarea tarea);
}
