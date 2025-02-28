package com.proyectoFinal.proyectoFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.proyectoFinal.proyectoFinal.model.Producto;
import com.proyectoFinal.proyectoFinal.service.IproductoService;

@RestController
public class ProductoController {
    @Autowired
    private IproductoService ServProducto;

    @GetMapping("/productos")
    
    public List<Producto> getProductos() {

        return ServProducto.getProductos();
    }

    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto pro) {
        ServProducto.saveProducto(pro);
        return "Producto guardado";
    }

    @DeleteMapping("/productos/eliminar/{id_producto}")
    public String deleteProducto(@PathVariable Long id_producto) {
        ServProducto.deleteProducto(id_producto);
        return "Producto eliminado";
    }

    @GetMapping("/productos/{id_producto}")
    public Producto findCliente(@PathVariable Long id_producto) {
        Producto pro = ServProducto.findProducto(id_producto);
        return pro;
    }

    @PutMapping("/productos/{id_productos}")
    public void editProducto(@RequestBody Long id_producto) {
        ServProducto.editProducto(id_producto);
        

    }

    @GetMapping("/productos/low_stock")
    public List<Producto> lowStock() {
        return ServProducto.lowStock();
    }

}
