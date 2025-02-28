package com.proyectoFinal.proyectoFinal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoFinal.proyectoFinal.model.Producto;
import com.proyectoFinal.proyectoFinal.repository.IProductoRepository;

@Service
public class ProductoService implements IproductoService {
   @Autowired
   private IProductoRepository repopro;

   @Override
   public List<Producto> getProductos() {
      List<Producto> listaProductos = repopro.findAll();
      return listaProductos;
   }

   @Override
   public String saveProducto(Producto pro) {
      repopro.save(pro);
      return "Producto guardado";
   }

   @Override
   public String deleteProducto(Long id_producto) {
      repopro.deleteById(id_producto);
      return "Producto eliminado";
   }

   @Override
   public Producto findProducto(Long id_producto) {
      Producto pro = repopro.findById(id_producto).orElse(null);
      return pro;
   }

   @Override
   public void editProducto(Long id_producto) {
      Producto pro = this.findProducto(id_producto);
      this.saveProducto(pro);
   }

   @Override
   public List<Producto> lowStock() {
      List<Producto> listaProductos = this.getProductos();
      List<Producto> listaLowStock = new ArrayList<Producto>();
      for (Producto prod : listaProductos) {
         if (prod.getCantidad_disponible() <= 5) {
            listaLowStock.add(prod);
         }
      }

      return listaLowStock;
   }

}
