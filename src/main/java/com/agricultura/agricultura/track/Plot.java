package com.agricultura.agricultura.track;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double size;

    private PlotType type;

    private PlotStatus status;

    public Plot() {

    }

    public Plot(Long id, String name, Double size, PlotType type, PlotStatus status) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.type = type;
        this.status = status;
    }

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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public PlotType getType() {
        return type;
    }

    public void setType(PlotType type) {
        this.type = type;
    }

    public PlotStatus getStatus() {
        return status;
    }

    public void setStatus(PlotStatus status) {
        this.status = status;
    }
}
