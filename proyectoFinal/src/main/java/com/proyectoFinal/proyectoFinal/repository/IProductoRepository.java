package com.proyectoFinal.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoFinal.proyectoFinal.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {

}
