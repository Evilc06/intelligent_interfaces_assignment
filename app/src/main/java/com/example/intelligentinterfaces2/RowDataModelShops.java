package com.example.intelligentinterfaces2;

public class RowDataModelShops {
    String item;
    Integer imageName;

    public Integer getName() {
        return imageName;
    }

    public void setName(Integer name) {
        this.imageName = name;
    }

    public RowDataModelShops(String item, Integer name){
        this.item = item;
        this.imageName = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}
