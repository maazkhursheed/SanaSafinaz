package com.attribe.sanasafinaz.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Maaz on 7/14/2016.
 */
public class ParentCategory implements Serializable {

    private int id;
    private String name;
    private String created_at;
    private String updated_at;
    private String image;
    private ArrayList<ChildCategory> child_categories = new ArrayList<ChildCategory>();

    public ParentCategory(int id, String name, String created_at, String updated_at, String image, ArrayList<ChildCategory> childCategories) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.image = image;
        this.child_categories = childCategories;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<ChildCategory> getChild_categories() {
        return child_categories;
    }

    public void setChild_categories(ArrayList<ChildCategory> child_categories) {
        this.child_categories = child_categories;
    }
}
