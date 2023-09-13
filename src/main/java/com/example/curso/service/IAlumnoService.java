package com.example.curso.service;

import com.example.curso.entity.Alumno;
import com.example.curso.request.AlumnoRequest;

import java.util.List;

public interface IAlumnoService {

    public List<Alumno> buscarAlumnos();

    public void registrarAlumno(AlumnoRequest alumnoRequest);

    public String actualizarAlumno(AlumnoRequest alumnoRequest);

    public String eliminarAlumno(int idAlumno);

}