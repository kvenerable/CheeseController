package org.launchcode.cheesemvc.models;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class cheese {
    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message ="Description must not be empty")
    private String description;

    private CheeseType type;

    private int cheeseId;
    private static int nextId = 1;

    @NotNull
    @Range(min=1, max=5, message = "please add rating")
    private int rating;

    public cheese(String name, String description, Integer rating) {
        this();
        this.name = name;
        this.description = description;
        this.rating = rating;

    }

    public cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
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

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
