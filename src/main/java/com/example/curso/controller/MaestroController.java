package com.example.curso.controller;

import com.example.curso.request.MaestroRequest;
import com.example.curso.service.IMaestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MaestroController {

    @Autowired
    private IMaestroService maestroService;

    @GetMapping("/maestros")
    public ResponseEntity<?> consultarMaestros() {
        return ResponseEntity.status(HttpStatus.OK).body((maestroService.buscarMaestros()));
    }

    @PostMapping("/maestros")
    public ResponseEntity<?> registrarMaestro(@RequestBody MaestroRequest maestroRequest) {
        maestroService.registrarMaestro(maestroRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Maestro creado con éxito");
    }

    @PutMapping("/maestros")
    public ResponseEntity<?> actualizarMaestro(@RequestBody MaestroRequest maestroRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(maestroService.actualizarMaestro(maestroRequest));
    }

    @DeleteMapping("/maestros/{id}")
    public ResponseEntity<?> eliminarMaestro(@PathVariable("id") int matricula) {
        return ResponseEntity.status(HttpStatus.OK).body(maestroService.eliminarMaestro(matricula));
    }

}
