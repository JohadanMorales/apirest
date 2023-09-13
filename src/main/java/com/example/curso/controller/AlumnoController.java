package com.example.curso.controller;

import com.example.curso.request.AlumnoRequest;
import com.example.curso.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping("/alumnos")
    public ResponseEntity<?> consultarAlumnos() {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.buscarAlumnos());
    }

    @PostMapping("/alumnos")
    public ResponseEntity<?> registrarAlumno(@RequestBody AlumnoRequest alumnoRequest) {
        alumnoService.registrarAlumno(alumnoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Alumno creado con éxito");
    }

    @PutMapping("/alumnos")
    public ResponseEntity<?> actualizarAlumno(@RequestBody AlumnoRequest alumnoRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.actualizarAlumno(alumnoRequest));
    }

    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable("id") int idAlumno) {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.eliminarAlumno(idAlumno));
    }
    
}