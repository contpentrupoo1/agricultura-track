package com.agricultura.agricultura.track;

import jakarta.persistence.*;

@Entity

public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double size;
    @Enumerated(EnumType.STRING)
    private PlotType type;

    @Enumerated(EnumType.STRING)
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
