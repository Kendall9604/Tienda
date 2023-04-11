package com.Tienda.service;

import com.Tienda.domain.Cliente;
import java.util.List;

public interface ClienteService {

    //firma de los metodos 
    public List<Cliente> getClientes();

    public Cliente getCliente(Cliente cliente);

    public void save(Cliente cliente); // Sirve para insertar y modificar un registro

    public void delete(Cliente cliente);
    
    public List<Cliente> getClienteCorreo(String correo);

    public List<Cliente> consulta(String apellidos);

}//Fin
