package com.inpost.price.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
@Data
@Table(name = "product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Type(type = "uuid-char")
    UUID uuid;
    BigDecimal price;

}
