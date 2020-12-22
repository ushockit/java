package org.itstep.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private double price;
    private String image;
    private CategoryDto category;
}
