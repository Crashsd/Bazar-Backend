package com.proyectoFinal.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoFinal.proyectoFinal.model.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {

}
