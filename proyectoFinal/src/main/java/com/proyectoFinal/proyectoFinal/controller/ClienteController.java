package com.proyectoFinal.proyectoFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoFinal.proyectoFinal.model.Cliente;
import com.proyectoFinal.proyectoFinal.service.IClienteService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService servCliente;

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {

        return servCliente.getClientes();
    }

    @PostMapping("/clientes/crear")
    public String saveClientes(@RequestBody Cliente cli) {
        servCliente.saveCliente(cli);
        return "Cliente guardado";
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente) {
        servCliente.deleteCliente(id_cliente);
        return "Cliente eliminado";
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente) {
        Cliente cli = servCliente.findCliente(id_cliente);
        return cli;
    }

    @PutMapping("/clientes/{id_cliente}")
    public void editCliente(@RequestBody Long id_cliente) {
        servCliente.editCliente(id_cliente);

    }

}
