package com.example.integratedsj2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


public enum Status {
    NO_STATUS,
    TO_DO,
    DOING,
    DONE
}
