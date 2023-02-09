package com.example.country.model;
import jakarta.persistence.*;

@Entity
@Table(name="country")

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name = "population")
    private long population;
    public Country(){

    }

    public Country(String name, long population){
        this.name=name;
        this.population=population;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString(){
        return String.format("Country: id = %s, name = %s, population = %s", id, name, population);
    }
}
