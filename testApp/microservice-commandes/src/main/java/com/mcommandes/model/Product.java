package com.mcommandes.model;


import com.mproduits.model.Panier;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String titre;

    private String description;

    private String image;

    private Double prix;


    public Product() {
    }

    public Product(int id, String titre, String description, String image, Double prix) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", prix=" + prix +
                '}';
    }
   @ManyToMany
    @JoinTable(
            name = "panier_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "panier_id"))
    private Set<Panier> paniers = new HashSet<>();


    // Getter and setter for paniers
    public Set<Panier> getPaniers() {
        return paniers;
    }

    public void setPaniers(Set<Panier> paniers) {
        this.paniers = paniers;
    }

}
