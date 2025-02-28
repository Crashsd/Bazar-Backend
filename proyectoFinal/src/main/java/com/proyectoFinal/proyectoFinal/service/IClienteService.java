package com.proyectoFinal.proyectoFinal.service;

import java.util.List;

import com.proyectoFinal.proyectoFinal.model.Cliente;

public interface IClienteService {

    public List<Cliente> getClientes();

    public String saveCliente(Cliente cliente);

    public String deleteCliente(Long id_cliente);

    public Cliente findCliente(Long id_cliente);

    public void editCliente(Long id_cliente);
}
