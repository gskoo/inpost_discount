package com.inpost.price.discount;

import com.inpost.price.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class NoDiscountCalculator implements DiscountCalculator {

    @Override
    public BigDecimal getPrice(Product product, Integer amount) {
        return product.getPrice()
                .multiply(BigDecimal.valueOf(amount));
    }
}
