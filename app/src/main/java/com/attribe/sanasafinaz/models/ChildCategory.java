package com.attribe.sanasafinaz.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maaz on 7/15/2016.
 */
public class ChildCategory implements Serializable {

    private int id;
    private String name;
    private int parent_id;
    private String created_at;
    private String updated_at;
    private List<Menu> menus = new ArrayList<Menu>();

    public ChildCategory(int id, String name, int parent_id, String created_at, String updated_at, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.parent_id = parent_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.menus = menus;
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

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
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

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

}
