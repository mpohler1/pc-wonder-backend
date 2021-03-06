package com.pcwonder.api.product.cooling;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Cooling extends Product {
    private int size;
    private double length;
    private double width;
    private double height;
    private double weight;
}
