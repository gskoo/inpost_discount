package com.inpost.price.discount;

import com.inpost.price.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PercentageDiscountCalculatorTest {

    static PercentageDiscountCalculator percentageDiscount;
    @BeforeAll
    public static void setUp() {
        percentageDiscount = new PercentageDiscountCalculator();
        ReflectionTestUtils.setField(percentageDiscount, "percentage", new BigDecimal("0.40"));

    }

    @Test
    void getDiscountTest() {

        Product product;
        product = new Product( UUID.randomUUID(), new BigDecimal("10"));
        BigDecimal discount = percentageDiscount.getPrice(product, 10);
        assertEquals(new BigDecimal("40.00"),discount);
    }
}