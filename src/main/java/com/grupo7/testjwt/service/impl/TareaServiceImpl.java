package com.grupo7.testjwt.service.impl;

import com.grupo7.testjwt.entity.Tarea;
import com.grupo7.testjwt.exception.GeneralException;
import com.grupo7.testjwt.exception.NoDataFoundException;
import com.grupo7.testjwt.exception.ValidateException;
import com.grupo7.testjwt.repository.TareaRepository;
import com.grupo7.testjwt.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {
    @Autowired
    private TareaRepository repository;

    @Override
    public List<Tarea> findAll(Pageable page) {
        return List.of();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> findAll() {
        try {
            List<Tarea> registros = repository.findAll();
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidorr");
        } catch (Exception e) {
            throw new GeneralException("xd");
        }
    }

    @Override
    public List<Tarea> findByUsuario(String username) {
        try {
            List<Tarea> registros = repository.findByUsuario_Username(username);
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    public Tarea save(Tarea tarea) {
        try {
            if(tarea.getId() == 0) {
                Tarea nuevo = repository.save(tarea);
                return nuevo;
            }

            Tarea registro = repository.findById(tarea.getId())
                    .orElseThrow(() -> new NoDataFoundException("No existe un registro con ese id"));
            registro.setTitulo(tarea.getTitulo());
            registro.setDescripcion(tarea.getDescripcion());
            registro.setFechaInicio(tarea.getFechaInicio());
            registro.setFechaFin(tarea.getFechaFin());
            registro.setFechaLimite(tarea.getFechaLimite());
            repository.save(registro);

            return registro;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }
}
