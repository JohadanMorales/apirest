package com.example.curso.entity;

import jakarta.persistence.*;

@Entity
@Table(name="alumnos")
public class Alumno {
    @Id
    @Column(name = "id_alumno")
    @SequenceGenerator(name = "alumnos_id_alumno_seq", sequenceName = "alumnos_id_alumno_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumnos_id_alumno_seq")
    private int idAlumno;

    private String nombre;

    private int edad;

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
