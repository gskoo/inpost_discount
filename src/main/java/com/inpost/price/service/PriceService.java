package com.inpost.price.service;

import com.inpost.price.discount.AmountDiscountCalculator;
import com.inpost.price.discount.DiscountCalculator;
import com.inpost.price.discount.NoDiscountCalculator;
import com.inpost.price.discount.PercentageDiscountCalculator;
import com.inpost.price.model.DiscountType;
import com.inpost.price.model.Product;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.inpost.price.model.DiscountType.*;


@Service
@Slf4j
@Data
public class PriceService {
    private final AmountDiscountCalculator amountDiscountCalculator;
    private final  PercentageDiscountCalculator percentageDiscountCalculator;
    private final NoDiscountCalculator noDiscountCalculator;

    public BigDecimal calculatePrice(Product product, Integer amount, DiscountType discountType) {
        return getDiscountCalculator(discountType).getDiscount(product, amount);
    }

    private DiscountCalculator getDiscountCalculator(DiscountType discountType) {
        switch (discountType) {
            case AMOUNT -> {
                return amountDiscountCalculator;
            }
            case PERCENTAGE -> {
                return percentageDiscountCalculator;
            }
            default -> {
                return noDiscountCalculator;
            }
        }
    }


}
