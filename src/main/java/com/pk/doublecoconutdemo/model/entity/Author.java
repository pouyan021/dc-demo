package com.pk.doublecoconutdemo.model.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "author")
public class Author implements Serializable {

    @Serial
    private static final long serialVersionUID = 2703818222116851991L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @Column(name = "birth_date")
    private Instant birthDate;

    @Column(name = "email")
    @Type(type = "org.hibernate.type.TextType")
    private String email;

    public Long getId() {
        return id;
    }

    public Author setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public Author setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Author setEmail(String email) {
        this.email = email;
        return this;
    }

}
