package com.example.curso.impl;

import com.example.curso.entity.Maestros;
import com.example.curso.repository.IMaestroRepository;
import com.example.curso.request.MaestroRequest;
import com.example.curso.service.IMaestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaestroServiceImpl implements IMaestroService {

    @Autowired
    private IMaestroRepository maestroRepository;

    @Override
    public List<Maestros> buscarMaestros() {
        return maestroRepository.findAll();
    }

    @Override
    public void registrarMaestro(MaestroRequest maestroRequest) {
        Maestros objMaestro = new Maestros();
        objMaestro.setNombre(maestroRequest.getNombre());
        objMaestro.setPaterno(maestroRequest.getPaterno());
        objMaestro.setMaterno(maestroRequest.getMaterno());
        objMaestro.setEdad(maestroRequest.getEdad());
        objMaestro.setGradoEstudios(maestroRequest.getGradoEstudios());
        maestroRepository.save(objMaestro);
    }

    @Override
    public String actualizarMaestro(MaestroRequest maestroRequest) {
        Maestros objMaestro = maestroRepository.findById(maestroRequest.getMatricula()).orElse(null);

        if (objMaestro != null) {
            objMaestro.setNombre(maestroRequest.getNombre());
            objMaestro.setPaterno(maestroRequest.getPaterno());
            objMaestro.setMaterno(maestroRequest.getMaterno());
            objMaestro.setEdad(maestroRequest.getEdad());
            objMaestro.setGradoEstudios(maestroRequest.getGradoEstudios());
            maestroRepository.save(objMaestro);
            return "El maestro se actualizó con éxito";
        } else {
            return "El maestro no existe";
        }

    }

    @Override
    public String eliminarMaestro(int matricula) {
        Maestros objMaestro = maestroRepository.findById(matricula).orElse(null);
        if (objMaestro != null) {
            maestroRepository.deleteById(matricula);
            return "Maestro eliminado con éxito";
        } else {
            return "El maestro no existe";
        }
    }
}
