package com.les2.hello.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;

    @OneToOne
    @JoinColumn(name="chip_id")
    private Chip chip;

    @OneToMany
    @JsonManagedReference
    private List<Kitten> kittens = new ArrayList<>();

    // CONSTRUCTORS
    public Cat() {}

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public Chip getChip() {
        return chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Kitten> getKittens() {
        return kittens;
    }

    public void setKittens(List<Kitten> kittens) {
        this.kittens = kittens;
    }

}
