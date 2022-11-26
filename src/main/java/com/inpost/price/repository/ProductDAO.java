package com.inpost.price.repository;

import com.inpost.price.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductDAO extends JpaRepository<Product, UUID> {


}