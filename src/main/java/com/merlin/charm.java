package com.merlin;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class charm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String colour;
    private String feature;

    public charm(String name, String colour, String feature) {
        this.name = name;
        this.colour = colour;
        this.feature = feature;
    }

    public charm() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public String getFeature() {
        return feature;
    }
    public void setFeature(String feature) {
        this.feature = feature;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        charm charm = (charm) o;
        return Objects.equals(name, charm.name) && Objects.equals(colour, charm.colour) && Objects.equals(feature, charm.feature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, colour, feature); // Use the fields to generate a hash code
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
