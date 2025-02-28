package com.proyectoFinal.proyectoFinal.service;

import java.util.List;

import com.proyectoFinal.proyectoFinal.model.Producto;

public interface IproductoService {

    public List<Producto> getProductos();

    public String saveProducto(Producto pro);

    public String deleteProducto(Long id_producto);

    public Producto findProducto(Long id_producto);

    public void editProducto(Long id_producto);

    public List<Producto> lowStock();
}
