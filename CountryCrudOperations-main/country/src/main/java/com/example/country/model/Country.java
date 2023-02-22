package com.example.country.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="country")
@NoArgsConstructor
@Getter @Setter
@ToString
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name = "population")
    private long population;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<City> cities = new ArrayList<>();

    public Country(String name, long population) {
        this.name = name;
        this.population = population;
    }
}
