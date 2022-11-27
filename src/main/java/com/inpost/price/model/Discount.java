package com.inpost.price.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Discount {
    BigDecimal discount;
}
