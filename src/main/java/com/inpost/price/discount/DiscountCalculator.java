package com.inpost.price.discount;

import com.inpost.price.model.Product;

import java.math.BigDecimal;

public interface DiscountCalculator {
    public BigDecimal getDiscount(Product product, Integer amount);
}
