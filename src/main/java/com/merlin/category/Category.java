package com.merlin.category;

import com.merlin.charm.Charm;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories") // Tablo adı belirtmek iyi pratik
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 100 ,unique = true) // Constraint'ler eklemek iyi pratik
    private String name;

    @OneToMany(mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Charm> charms = new ArrayList<>(); // Initialize etmek NPE'yi önler



    // Constructors
    public Category() {
    }

    public Category(String name) {
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

    // Convenience methods (opsiyonel)
    public void addCharm(Charm charm) {
        charms.add(charm);
        charm.setCategory(this);
    }

    public void removeCharm(Charm charm) {
        charms.remove(charm);
        charm.setCategory(null);
    }

    // toString, equals, hashCode metodları da eklenebilir
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}