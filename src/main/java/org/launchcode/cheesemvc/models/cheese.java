package org.launchcode.cheesemvc.models;

import org.hibernate.validator.constraints.Range;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class cheese {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15, message = "Name must not be empty or more than 15 characters long")
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    private CheeseType type;

    @NotNull
    @Range(min=1, max=5, message = "Please enter a valid rating")
    private Integer rating;


    public cheese(String name, String description, Integer rating) {
        // Call the default constructor for the given class
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    // Make no-arg constructor to use nextId to initialize the cheese ID field
    // Ensures it's unique for every single cheese object created
    public cheese() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }

}