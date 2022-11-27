package com.inpost.price.service;

import com.inpost.price.discount.AmountDiscountCalculator;
import com.inpost.price.discount.DiscountCalculator;
import com.inpost.price.discount.PercentageDiscountCalculator;
import com.inpost.price.model.DiscountType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;


class DiscountContextTest {

    @ParameterizedTest
    @MethodSource("provideAllDiscountTypes")
    void getDiscountCalculatorAllTypesAreHandled(DiscountType discountType) {
        AmountDiscountCalculator amountDiscountCalculator = Mockito.mock(AmountDiscountCalculator.class);
        PercentageDiscountCalculator percentageDiscountCalculator = Mockito.mock(PercentageDiscountCalculator.class);
        DiscountContext discountContext = new DiscountContext(amountDiscountCalculator, percentageDiscountCalculator);
        assertInstanceOf(DiscountCalculator.class, discountContext.getDiscountCalculator(discountType));
    }

    private static Stream<DiscountType> provideAllDiscountTypes() {

        return Stream.of(DiscountType.values());

    }
}