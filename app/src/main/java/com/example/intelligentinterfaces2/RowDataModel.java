package com.example.intelligentinterfaces2;

public class RowDataModel {
    String item;
    Integer imageName;

    public RowDataModel(String item, Integer name){
        this.item = item;
        this.imageName = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getImageName() {
        return imageName;
    }

    public void setImageName(Integer imageName) {
        this.imageName = imageName;
    }

}
