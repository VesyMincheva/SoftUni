package com.softuin.Battleships.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "health", nullable = false)
    private Long health;
    @Column(name = "power", nullable = false)
    private Long power;

    @Column(name = "created", nullable = false)
    private LocalDate created;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    public Ship() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
