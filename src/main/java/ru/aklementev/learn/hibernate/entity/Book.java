package ru.aklementev.learn.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Setter @Getter
public class Book implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Генерация ID через автоинкремент
    private String id;

    private String name;

    private long author_id;


}
