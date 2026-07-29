package com.agricultura.agricultura.track;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class ExpenseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    private String productionphase;

    private Double quantityused;

    private Double totalcost;

    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getProductionphase() {
        return productionphase;
    }

    public void setProductionphase(String productionphase) {
        this.productionphase = productionphase;
    }

    public Double getQuantityused() {
        return quantityused;
    }

    public void setQuantityused(Double quantityused) {
        this.quantityused = quantityused;
    }

    public Double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(Double totalcost) {
        this.totalcost = totalcost;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ExpenseLog() {
    }
}
