package com.kosmos.consultorio.springbootconsultorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmos.consultorio.springbootconsultorio.models.Product;
import com.kosmos.consultorio.springbootconsultorio.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    // Método para obtener todos los productos
    public List<Product> findAll() {
        return repository.findAll();
    }

    // Método para guardar un producto
    public void save(Product product) {
        repository.save(product);
    }

    // Método para buscar un producto por id
    public Product findById(Integer id) {
        return repository.findById(id).get();
    }

    // Método para eliminar un producto por id
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}