/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Kendall
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    ClienteDao clienteDao;

    @GetMapping("/")
    public String page(Model model) {
        log.info("Ahora utilizando MVC");
//        String mensaje=  "Estamos en semana 4, saludos!";
//        model.addAttribute("mensajeSaludo", mensaje);

//        Cliente cliente= new Cliente ("kendall", "Arguello", "kendall@gmail.com", "888-8888");
//        Cliente cliente2= new Cliente ("David", "Villalobos", "david@gmail.com", "888-9999");
//        Cliente cliente3= new Cliente ("kendall", "Arguello", "kendall@gmail.com", "888-8888");
//        //model.addAttribute("cliente", cliente);
//        
//        List<Cliente> clientes = Arrays.asList(cliente, cliente2);
//        model.addAttribute("clientes", clientes);
        var clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);

        return "index";

    }

}
