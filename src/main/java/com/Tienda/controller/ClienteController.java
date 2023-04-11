package com.Tienda.controller;

import com.Tienda.domain.Cliente;
import com.Tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/cliente/listado")
    public String page(Model model) {
        var clientes = clienteService.getClientes();
//        var clientes= clienteService.getClienteCorreo("jcastro@gmail.com");
        model.addAttribute("clientes", clientes);

        return "/cliente/listado";

    }

    @GetMapping("/cliente/nuevo")

    public String nuevoCliente(Cliente cliente) {
        return "/cliente/modificar";  // retorna nombre del  html
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }

    @RequestMapping(value = "cliente/consulta", method = RequestMethod.GET)
    public String consulta(@RequestParam(value = "apellidos", required = false) String apellidos, Model model) {
        model.addAttribute("cliente", clienteService.consulta(apellidos));
        return "cliente/consulta";
    }

}
