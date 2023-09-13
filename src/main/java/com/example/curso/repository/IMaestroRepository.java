package com.example.curso.repository;

import com.example.curso.entity.Maestros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaestroRepository extends JpaRepository<Maestros, Integer> {

}
