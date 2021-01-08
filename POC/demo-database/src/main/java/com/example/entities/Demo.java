package com.example.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Demo {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
}
