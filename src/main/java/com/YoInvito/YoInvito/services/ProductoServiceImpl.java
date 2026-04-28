package com.YoInvito.YoInvito.services;

import com.YoInvito.YoInvito.exceptions.ProductoException;
import com.YoInvito.YoInvito.models.Producto;
import com.YoInvito.YoInvito.models.Restaurant;
import com.YoInvito.YoInvito.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {
        return this.productoRepository.findAll();
    }


    @Transactional(readOnly = true)
    @Override
    public Producto findById(Long id) {
        return this.productoRepository.findById(id).orElseThrow(
                ()-> new ProductoException("Producto con ID:" +id + "no se encuentra"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Producto> findByName(String name) {
        return this.productoRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Producto> findByRestaurant(Restaurant restaurant) {
        return this.productoRepository.findByRestaurant(restaurant);
    }

    @Transactional
    @Override
    public Producto update(Long id, Producto producto) {
        return this.productoRepository.findById(id).map(updated->{
            updated.setNombreProducto(producto.getNombreProducto());
            updated.setRestaurant(producto.getRestaurant());
            updated.setPrecio(producto.getPrecio());
            return this.productoRepository.save(updated);
        }).orElseThrow(
                ()-> new ProductoException("Producto con ID:" +id + "no se encuentra"));
    }

    @Transactional
    @Override
    public Producto save(Producto producto) {
        if(this.productoRepository.findById(producto.getIdProducto()).isPresent()){
            throw new ProductoException("Producto con ID:" +producto.getIdProducto() + " ya existe");
        }
        Producto newProducto= new Producto();
        newProducto.setNombreProducto(producto.getNombreProducto());
        newProducto.setRestaurant(producto.getRestaurant());
        newProducto.setPrecio(producto.getPrecio());
        newProducto.setDescripcion(producto.getDescripcion());
        return productoRepository.save(newProducto);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        this.productoRepository.deleteById(id);
    }
}
