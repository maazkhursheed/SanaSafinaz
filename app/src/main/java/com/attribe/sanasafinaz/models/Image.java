package com.attribe.sanasafinaz.models;

/**
 * Created by Maaz on 7/15/2016.
 */
public class Image {

    private int id;
    private String created_at;
    private String updated_at;
    private String url;

    public Image(int id, String created_at, String updated_at, String url) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
