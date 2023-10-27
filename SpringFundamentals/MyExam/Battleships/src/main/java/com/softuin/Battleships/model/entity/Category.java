package com.softuin.Battleships.model.entity;

import com.softuin.Battleships.model.enums.CategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(name = "name", nullable = false, unique = true)
    @Enumerated(EnumType.ORDINAL)
    private CategoryEnum name;
    @Column(name = "description", nullable = true, columnDefinition = "text")
    private String description;

    public Category() {
    }

    public Category(CategoryEnum categoryEnum){
        this.name = categoryEnum;
    }

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
