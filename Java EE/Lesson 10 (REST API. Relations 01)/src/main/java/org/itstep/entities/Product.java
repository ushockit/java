package org.itstep.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private double price;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
