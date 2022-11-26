package com.inpost.price.repository;

import com.inpost.price.exception.ProductNotFoundException;
import com.inpost.price.model.Product;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Data
public class ProductRepository {

    final ProductDAO productDAO;
    public Product findById(UUID uuid) {
        return productDAO
                .findById(uuid)
                .orElseThrow(()-> new ProductNotFoundException(uuid));
    }
}
