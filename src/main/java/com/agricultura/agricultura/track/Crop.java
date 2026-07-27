package com.agricultura.agricultura.track;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idaplot;

    private String name;

    private LocalDate start;

    private CropStatus status;

    private Double totalyield;

    private String variety;

}
