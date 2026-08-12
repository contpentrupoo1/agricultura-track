package com.agricultura.agricultura.track.Entity;

import jakarta.persistence.*;

@Entity

@Table(name = "user_farm_roles")
public class UserFarmRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "permission_level")
    private String permissionlevel;

}
