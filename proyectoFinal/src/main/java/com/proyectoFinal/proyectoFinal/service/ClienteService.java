package com.proyectoFinal.proyectoFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoFinal.proyectoFinal.model.Cliente;
import com.proyectoFinal.proyectoFinal.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository repoCliente;

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = repoCliente.findAll();
        return listaClientes;
    }

    @Override
    public String saveCliente(Cliente cliente) {
        repoCliente.save(cliente);
        return "El cliente fue guardado";
    }

    @Override
    public String deleteCliente(Long id_cliente) {
        repoCliente.deleteById(id_cliente);
        return "Cliente eliminado";

    }

    @Override
    public Cliente findCliente(Long id_cliente) {
        Cliente cliente = repoCliente.findById(id_cliente).orElse(null);
        return cliente;
    }

    @Override
    public void editCliente(Long id_cliente) {
        Cliente cli = this.findCliente(id_cliente);
        this.saveCliente(cli);
    }

}
