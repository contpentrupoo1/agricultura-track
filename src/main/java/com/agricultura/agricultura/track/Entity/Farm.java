package com.agricultura.agricultura.track.Entity;

import jakarta.persistence.*;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long totalacres;


}
