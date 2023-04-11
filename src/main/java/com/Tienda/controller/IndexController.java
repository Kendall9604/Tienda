/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda.controller;

import com.Tienda.domain.Cliente;
import com.Tienda.service.ArticuloService;
import com.Tienda.service.ClienteService;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Kendall
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    ArticuloService articuloService;

    @GetMapping("/")
    public String page(Model model) {
        log.info("Ahora utilizando MVC");
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);

        return "index";

    }
    
    

//    @GetMapping("/nuevoCliente")
//
//    public String nuevoCliente(Cliente cliente) {
//        return "modificarCliente";  // retorna nombre del  html
//    }
//
//    @PostMapping("/guardarCliente")
//    public String guardarCliente(Cliente cliente) {
//        clienteService.save(cliente);
//        return "redirect:/";
//    }
//
//    @GetMapping("/modificarCliente/{idCliente}")
//    public String modificarCliente(Cliente cliente, Model model) {
//        cliente = clienteService.getCliente(cliente);
//        model.addAttribute("cliente", cliente);
//        return "modificarCliente";
//    }
//
//    @GetMapping("/eliminarCliente/{idCliente}")
//    public String eliminarCliente(Cliente cliente) {
//        clienteService.delete(cliente);
//        return "redirect:/";
//    }

}
