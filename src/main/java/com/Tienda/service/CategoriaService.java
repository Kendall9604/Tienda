
package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;



public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria); // Sirve para insertar y modificar un registro
    
    public void delete (Categoria categoria);
    
}
