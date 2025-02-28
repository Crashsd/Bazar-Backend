package com.proyectoFinal.proyectoFinal.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoFinal.proyectoFinal.model.Venta;
import com.proyectoFinal.proyectoFinal.service.IVentaService;

@RestController
public class VentaController {
    @Autowired
    private IVentaService servVenta;

    @GetMapping("/ventas")
    public List<Venta> getVentas() {

        return servVenta.getVentas();
    }

    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta ven) {
        servVenta.saveVenta(ven);
        return "Venta gurdada";
    }

    @DeleteMapping("/ventas/eliminar/{id_venta}")
    public String deleteVenta(@PathVariable Long id_venta) {
        servVenta.deleteVenta(id_venta);
        return "Venta eliminada";
    }

    @GetMapping("/ventas/{id_venta}")
    public Venta findVenta(@PathVariable Long id_venta) {
        Venta ven = servVenta.findVenta(id_venta);
        return ven;
    }

    @PutMapping("/ventas/{id_venta}")
    public void editVenta(@RequestBody Long id_venta) {
        servVenta.editVenta(id_venta);

    }

    @GetMapping("/ventas/productos/{id_venta}")
    public Venta getListaProductos(@PathVariable Long id_venta) {
        Venta ven = servVenta.getlistaProductos(id_venta);
        return ven;
    }

    @GetMapping("/ventas/{fecha_venta}")
    public List<Venta> getTotalFecha(@PathVariable LocalDate fecha_venta) {

        return servVenta.getTotalFecha(fecha_venta);
    }

}
