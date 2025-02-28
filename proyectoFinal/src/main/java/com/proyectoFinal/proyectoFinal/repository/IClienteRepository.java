package com.proyectoFinal.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoFinal.proyectoFinal.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Long> {

}
