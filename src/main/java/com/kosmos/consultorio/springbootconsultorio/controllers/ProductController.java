package com.kosmos.consultorio.springbootconsultorio.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kosmos.consultorio.springbootconsultorio.models.Product;
import com.kosmos.consultorio.springbootconsultorio.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
public class ProductController {
    
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        try {

            //Busca el producto
            Product product = productService.findById(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (Exception e) {

            //Retorna un error indicando que no se encontro el producto
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public void save(@Valid @RequestBody Product product){
        productService.save(product);
    }
    
    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Product product, @PathVariable Integer id){

        try {
            // Busca el producto en la bd
            Product productDb = productService.findById(id);

            // Actualiza los datos
            productDb.setName(product.getName());   
            productDb.setPrice(product.getPrice());

            // Guarda el producto
            productService.save(productDb);

            // Retorna un status 200
            return new ResponseEntity<Product>(HttpStatus.OK);

        } catch (Exception e) {
            //Retorna un error indicando que no se encontro el producto
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){

        try {
            // Busca el producto en la bd
            Product productDb = productService.findById(id);

            // Guarda el producto si es que existe
            productService.deleteById(productDb.getId());

            // Retorna un status 200
            return new ResponseEntity<Product>(HttpStatus.OK);

        } catch (Exception e) {
            //Retorna un error indicando que no se encontro el producto
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }



}