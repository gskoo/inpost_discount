package com.inpost.price.controller;


import com.inpost.price.model.DiscountType;
import com.inpost.price.model.Product;
import com.inpost.price.repository.ProductRepository;
import com.inpost.price.service.PriceService;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.UUID;

@RestController
@Data
@Validated
@RequestMapping("/")
public class DiscountController {

    private final PriceService priceService;
    private final ProductRepository productRepository;


    @GetMapping(value = "/discount", produces = "application/json")
    public BigDecimal calculateDiscount(
            @RequestParam UUID uuid,
            @RequestParam @Min(0) Integer amount,
            @RequestParam(required = false)  DiscountType discountType

            ) {

        Product product = productRepository.findById(uuid);
        return priceService.calculatePrice(product, amount, discountType);

    }
}