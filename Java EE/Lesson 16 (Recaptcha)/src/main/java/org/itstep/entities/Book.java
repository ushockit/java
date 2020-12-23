package org.itstep.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private int pages;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors = new ArrayList<>();
}
