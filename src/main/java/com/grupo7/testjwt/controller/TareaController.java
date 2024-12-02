package com.grupo7.testjwt.controller;

import com.grupo7.testjwt.converter.TareaConverter;
import com.grupo7.testjwt.dto.TareaDto;
import com.grupo7.testjwt.entity.Tarea;
import com.grupo7.testjwt.service.TareaService;
import com.grupo7.testjwt.util.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tareas")

public class TareaController {
    @Autowired
    private TareaService service;

    @Autowired
    private TareaConverter converter;

    @GetMapping
    public ResponseEntity<List<TareaDto>> findAll() {
        List<TareaDto> registros = converter.fromEntities(service.findAll());
        return new WrapperResponse(true, "success", registros).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<TareaDto>> findByUsuario(@PathVariable("username") String username) {
        List<TareaDto> registros = converter.fromEntities(service.findByUsuario(username));
        return new WrapperResponse(true, "success", registros).createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TareaDto> create(@RequestBody TareaDto registro) {
        Tarea entity = converter.fromDto(registro);
        TareaDto dto = converter.fromEntity(service.save(entity));
        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.OK);
    }
}
