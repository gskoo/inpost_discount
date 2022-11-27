package com.inpost.price.service;

import com.inpost.price.discount.AmountDiscountCalculator;
import com.inpost.price.discount.DiscountCalculator;
import com.inpost.price.discount.PercentageDiscountCalculator;
import com.inpost.price.exception.NoDiscountException;
import com.inpost.price.model.DiscountType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@Data
public class DiscountContext {
    private final AmountDiscountCalculator amountDiscountCalculator;
    private final  PercentageDiscountCalculator percentageDiscountCalculator;


    public DiscountCalculator getDiscountCalculator(DiscountType discountType) {

        if(discountType == null){
            throw new NoDiscountException();
        }
        switch (discountType) {
            case AMOUNT -> {
                return amountDiscountCalculator;
            }
            case PERCENTAGE -> {
                return percentageDiscountCalculator;
            }
        }
        throw new NoDiscountException();
    }


}
