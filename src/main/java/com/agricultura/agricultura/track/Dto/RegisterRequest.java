package com.agricultura.agricultura.track.Dto;
import com.agricultura.agricultura.track.Entity.WorkerType;

public record RegisterRequest(String name, String email, String password, WorkerType role) {}