package com.example.curso.impl;

import com.example.curso.entity.Alumno;
import com.example.curso.repository.IAlumnoRepository;
import com.example.curso.request.AlumnoRequest;
import com.example.curso.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> buscarAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public void registrarAlumno(AlumnoRequest alumnoRequest) {
        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoRequest.getNombre());
        alumno.setEdad(alumnoRequest.getEdad());
        alumnoRepository.save(alumno);
    }

    @Override
    public String actualizarAlumno(AlumnoRequest alumnoRequest) {

        Alumno alumno = alumnoRepository.findById(alumnoRequest.getIdAlumno()).orElse(null);

        if (alumno != null) {
            alumno.setNombre(alumnoRequest.getNombre());
            alumno.setEdad(alumnoRequest.getEdad());
            alumnoRepository.save(alumno);
            return "El alumno se actualizó con éxito";
        } else {
            return "El alumno no existe";
        }
    }

    @Override
    public String eliminarAlumno(int idAlumno) {
        Alumno alumno = alumnoRepository.findById(idAlumno).orElse(null);

        if (alumno != null) {
            alumnoRepository.deleteById(idAlumno);
            return "Alumno eliminado con éxito";
        } else {
            return "No existe el alumno";
        }

    }
}
