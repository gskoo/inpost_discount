package com.inpost.price.discount;

import com.inpost.price.model.Product;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AmountDiscountCalculator implements DiscountCalculator {

    @Value("${amount-discount.max-discount}")
    private BigDecimal maxPercentage ;
    @Value("${amount-discount.factor}")
    private BigDecimal factor ;

    @Override
    public BigDecimal getDiscount(Product product, Integer amount) {
        BigDecimal percentage = calculatePercentage(amount);
        return product.getPrice()
                .multiply(BigDecimal.valueOf(amount))
                .multiply(percentage);

    }

    private BigDecimal calculatePercentage(Integer amount) {
        BigDecimal percentage = factor.multiply(BigDecimal.valueOf(amount));
        return percentage.min(maxPercentage);
    }


}
