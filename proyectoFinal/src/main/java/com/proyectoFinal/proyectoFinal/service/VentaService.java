package com.proyectoFinal.proyectoFinal.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoFinal.proyectoFinal.dto.VentaProductoClienteDTO;
import com.proyectoFinal.proyectoFinal.model.Venta;
import com.proyectoFinal.proyectoFinal.repository.IVentaRepository;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaRepository repoventa;

    @Override
    public List<Venta> getVentas() {
        List<Venta> lisaVentas = repoventa.findAll();
        return lisaVentas;
    }

    @Override
    public String saveVenta(Venta ven) {
        repoventa.save(ven);
        return "Venta guardada";
    }

    @Override
    public String deleteVenta(Long id_venta) {
        repoventa.deleteById(id_venta);
        return "Venta eliminada";
    }

    @Override
    public Venta findVenta(Long id_venta) {
        Venta ven = repoventa.findById(id_venta).orElse(null);
        return ven;
    }

    @Override
    public void editVenta(Long id_venta) {
        Venta ven = this.findVenta(id_venta);
        this.saveVenta(ven);
    }

    @Override
    public Venta getlistaProductos(Long id_venta) {

        Venta ven = new Venta();
        ven.getListaProductos();
        return ven;
    }

    @Override
    public List<VentaProductoClienteDTO> getVentaPro() {
        List<Venta> listaVentas = this.getVentas();
        List<VentaProductoClienteDTO> listaventaProducto = new ArrayList<VentaProductoClienteDTO>();
        VentaProductoClienteDTO ventProDTO = new VentaProductoClienteDTO();
        for (Venta ven : listaVentas) {
            ventProDTO.setNombreCliente(ven.getUnCliente().getNombre());
            ventProDTO.setApellidoCliente(ven.getUnCliente().getApellido());
            ventProDTO.setId_venta(ven.getId_venta());
            ventProDTO.setTotal(ven.getTotal());
            ventProDTO.setCantidadProductos(ven.getListaProductos().size());

        }
        listaventaProducto.add(ventProDTO);
        return listaventaProducto;
    }

    @Override
    public Venta getFecha(Long id_venta) {
        Venta ven = new Venta();
        ven.getFecha_venta();
        return ven;
    }

    @Override
    public List<Venta> getTotalFecha(LocalDate fecha_venta) {

        List<Venta> listaVentas = this.getVentas();
        List<Venta> listaVentasFecha = new ArrayList<Venta>();
        @SuppressWarnings("unused")
        double total = 0;
        for (Venta ven : listaVentas) {
             
            if (ven.getFecha_venta().equals(fecha_venta)) {
                total+=ven.getTotal();
                listaVentasFecha.add(ven);
            }
        }
        return listaVentasFecha;
    }
}
