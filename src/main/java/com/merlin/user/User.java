package com.merlin.user;

import com.merlin.charm.Charm;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100,unique = true)
    private String name;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Charm> charms = new ArrayList<>();

    // Constructors
    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Charm> getCharms() {
        return charms;
    }

    public void setCharms(List<Charm> charms) {
        this.charms = charms;
    }


    public int getCharmCount() {
        return charms != null ? charms.size() : 0;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", charmCount=" + getCharmCount() +
                '}';
    }
}