package com.inpost.price.discount;

import com.inpost.price.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PercentageDiscountCalculator implements DiscountCalculator {
    @Value("${percentage-discount.discount}")
    BigDecimal percentage;

    @Override
    public BigDecimal getDiscount(Product product, Integer amount) {
        return product.getPrice()
                .multiply(BigDecimal.valueOf(amount))
                .multiply(percentage);

    }
}
