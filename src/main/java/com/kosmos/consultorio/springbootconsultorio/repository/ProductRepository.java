package com.kosmos.consultorio.springbootconsultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosmos.consultorio.springbootconsultorio.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}