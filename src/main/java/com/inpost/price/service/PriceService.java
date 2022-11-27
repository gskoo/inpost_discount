package com.inpost.price.service;

import com.inpost.price.model.Discount;
import com.inpost.price.model.DiscountType;
import com.inpost.price.model.Product;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@Slf4j
@Data
public class PriceService {

    private final DiscountContext discountContext;
    public Discount calculatePrice(Product product, Integer amount, DiscountType discountType) {
        return new Discount( discountContext
                .getDiscountCalculator(discountType)
                .getPrice(product, amount)
                .setScale(2));
    }

}
