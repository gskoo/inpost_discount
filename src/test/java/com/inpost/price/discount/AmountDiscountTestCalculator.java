package com.inpost.price.discount;

import com.inpost.price.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmountDiscountTestCalculator {

    static AmountDiscountCalculator amountDiscount;

    @BeforeAll
    public static void setUp() {
        amountDiscount = new AmountDiscountCalculator();
        ReflectionTestUtils.setField(amountDiscount, "maxPercentage", new BigDecimal("0.40"));
        ReflectionTestUtils.setField(amountDiscount, "factor", new BigDecimal("0.05"));
    }


    @ParameterizedTest
    @MethodSource("provideTestData")
    void getDiscount(Integer amount, String discount) {

        Product product = new Product(UUID.randomUUID(), new BigDecimal("10"));

        BigDecimal calculatedDiscount = amountDiscount.getPrice(product, amount);
        assertEquals(new BigDecimal(discount), calculatedDiscount);

    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(1, "0.50"),
                Arguments.of(2, "2.00"),
                Arguments.of(5, "12.50"),
                Arguments.of(100, "400.00"),
                Arguments.of(200, "800.00")
        );
    }


}