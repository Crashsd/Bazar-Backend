package com.proyectoFinal.proyectoFinal.service;

import java.time.LocalDate;
import java.util.List;

import com.proyectoFinal.proyectoFinal.dto.VentaProductoClienteDTO;
import com.proyectoFinal.proyectoFinal.model.Venta;

public interface IVentaService {
    public List<Venta> getVentas();

    public String saveVenta(Venta ven);

    public String deleteVenta(Long id_venta);

    public Venta findVenta(Long id_venta);

    public void editVenta(Long id_venta);

    public Venta getlistaProductos(Long id_venta);

    public Venta getFecha (Long id_venta);

    public List<VentaProductoClienteDTO> getVentaPro();
    
    public List <Venta> getTotalFecha(LocalDate fecha_venta);

}
