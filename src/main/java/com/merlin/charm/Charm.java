package com.merlin.charm;

import com.merlin.category.Category;
import com.merlin.user.User;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Charm {

    @Id
    @SequenceGenerator(name = "memento", sequenceName = "charm_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memento")
    private Long id;

    @Column(name="name",unique = true,nullable = false,columnDefinition = "TEXT") // Our code not connected to a database, so this is just a placeholder so we will fix it later
    private String name;
    private String colour;
    private String feature;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    
    public Charm(String name, String colour, String feature) {
        this.name = name;
        this.colour = colour;
        this.feature = feature;
    }

    public Charm() {
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
        Charm charm = (Charm) o;
        return Objects.equals(name, charm.name) && Objects.equals(colour, charm.colour) && Objects.equals(feature, charm.feature);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, colour, feature); // Use the fields to generate a hash code
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
