package com.proyectoFinal.proyectoFinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaProductoClienteDTO {
    private Long id_venta;
    private Double Total;
    private Integer cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentaProductoClienteDTO() {
    }

    public VentaProductoClienteDTO(Long id_venta,
                                   Double total, 
                                   Integer cantidadProductos, 
                                   String nombreCliente,
                                   String apellidoCliente) {
                                
        this.id_venta = id_venta;
        Total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }

}
