package com.inpost.price.repository;

import com.inpost.price.model.Product;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Data
public class ProductRepository {

    final ProductDAO productDAO;
    public Product findById(UUID uuid) {
        return productDAO.findAll().stream().findFirst().get();
    }
}
