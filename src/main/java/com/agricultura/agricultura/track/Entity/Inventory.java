package com.agricultura.agricultura.track.Entity;

import jakarta.persistence.*;

@Entity

public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Double unitcost;

    @Enumerated(EnumType.STRING)
    private Unit unittype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(Double unitcost) {
        this.unitcost = unitcost;
    }

    public Unit getUnittype() {
        return unittype;
    }

    public void setUnittype(Unit unittype) {
        this.unittype = unittype;
    }

    public Inventory() {
    }
}
