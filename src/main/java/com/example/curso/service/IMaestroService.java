package com.example.curso.service;

import com.example.curso.entity.Maestros;
import com.example.curso.request.MaestroRequest;

import java.util.List;

public interface IMaestroService {
    public List<Maestros> buscarMaestros();

    public void registrarMaestro(MaestroRequest maestroRequest);

    public String actualizarMaestro(MaestroRequest maestroRequest);

    public String eliminarMaestro(int matricula);
}
