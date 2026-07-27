package com.agricultura.agricultura.track;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class ExpenseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long batchid;

    private Long resourceid;

    private String productionphase;

    private Double quantityused;

    private Double totalcost;

    private LocalDateTime timestamp;

}
