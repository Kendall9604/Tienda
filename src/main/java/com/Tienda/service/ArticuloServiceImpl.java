
package com.Tienda.service;

import com.Tienda.dao.ArticuloDao;
import com.Tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service //Importar Siempre arriba
public class ArticuloServiceImpl implements ArticuloService{
    
    @Autowired
    ArticuloDao articuloDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean Activos) {
         return (List<Articulo>)articuloDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.deleteById(articulo.getIdArticulo());
    }
    
    
    
}