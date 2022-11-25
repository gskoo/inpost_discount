package com.inpost.price.discount;

import com.inpost.price.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PercentageDiscountTestCalculator {
    @Test
    void getDiscount() {
        PercentageDiscountCalculator percentageDiscount = new PercentageDiscountCalculator();
        Product product;
        product = new Product( UUID.randomUUID(), new BigDecimal("10"));
        BigDecimal discount = percentageDiscount.getDiscount(product, 10);
        assertEquals(new BigDecimal("40.00"),discount);
    }
}