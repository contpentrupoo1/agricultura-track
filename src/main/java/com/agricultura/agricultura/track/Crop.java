package com.agricultura.agricultura.track;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plotida")
    private Plot plot;

    private String name;

    private LocalDate start;

    @Enumerated(EnumType.STRING)
    private CropStatus status;

    private Double totalyield;

    private String variety;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public CropStatus getStatus() {
        return status;
    }

    public void setStatus(CropStatus status) {
        this.status = status;
    }

    public Double getTotalyield() {
        return totalyield;
    }

    public void setTotalyield(Double totalyield) {
        this.totalyield = totalyield;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public Crop() {
    }
}
