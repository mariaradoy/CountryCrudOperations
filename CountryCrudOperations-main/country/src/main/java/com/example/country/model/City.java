package com.example.country.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="cities")
@NoArgsConstructor
@Getter @Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name")
    private String name;

    @ManyToOne
    private Country country;

    public City(String name) {
        this.name = name;
    }
}
