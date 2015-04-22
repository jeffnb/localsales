package com.omnilabsinc.localsellers.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ocx on 4/21/15.
 */
public class Item {

    private String id;
    private List<Double> loc;
    private Integer photoCount;
    private Integer price;
    private Boolean sold;
    private String userId;

    @SerializedName("new")
    private Boolean isNew;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Double> getLoc() {
        return loc;
    }

    public void setLoc(List<Double> loc) {
        this.loc = loc;
    }

    public Integer getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(Integer photoCount) {
        this.photoCount = photoCount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }
}
