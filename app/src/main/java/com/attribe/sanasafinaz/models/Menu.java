package com.attribe.sanasafinaz.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maaz on 7/15/2016.
 */
public class Menu {

    private int id;
    private String name;
    private int price;
    private String description;
    private int category_id;
    private String created_at;
    private String updated_at;
    private Boolean approved;
    private List<Image> images = new ArrayList<Image>();

    public Menu(int id, String name, int price, String description, int category_id,
                String created_at, String updated_at, Boolean approved, List<Image> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category_id = category_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.approved = approved;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

}
