package com.omnilabsinc.localsellers.models;

import java.util.List;

/**
 * Created by ocx on 4/21/15.
 */
public class Seller {
    private String id;
    private String name;
    private Integer numberOfItems;
    private String photo;
    private List<Item> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
