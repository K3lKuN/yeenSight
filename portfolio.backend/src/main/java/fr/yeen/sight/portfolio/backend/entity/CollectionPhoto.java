package fr.yeen.sight.portfolio.backend.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class CollectionPhoto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_col;

    private String name;
    private String description;
    private String meta;

    @ManyToMany
    @JoinTable(name = "photo_collection",
            joinColumns = @JoinColumn(name = "id_col"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Photo> photoSet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public Set<Photo> getPhotoSet() {
        return photoSet;
    }
}
