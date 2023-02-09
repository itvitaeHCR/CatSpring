package com.les2.hello.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Chip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long code;

    @OneToOne(mappedBy = "chip")
    @JsonIgnore
    private Cat cat;

    // CONSTRUCTORS

    public Chip() {}

    public Chip(Long code, Cat cat) {
        this.code = code;
        this.cat = cat;
    }

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

}
