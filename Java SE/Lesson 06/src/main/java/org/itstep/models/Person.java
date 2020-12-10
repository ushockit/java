package org.itstep.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private int id;
    private String firstName;
    //transient - исключение поля из сериализации
    private transient String lastName;
}
