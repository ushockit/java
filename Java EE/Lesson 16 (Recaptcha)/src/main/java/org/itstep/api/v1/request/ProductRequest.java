package org.itstep.api.v1.request;

import lombok.Data;

@Data
public class ProductRequest {
    private long id;
    private String name;
    private String description;
    private double price;
    private String image;
    private long categoryId;
}
