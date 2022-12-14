package com.example.swpufinalproject;

public class CommodityHelper {

    private static Integer id;
    String name;
    String price;
    String location;

    public CommodityHelper(String name, String price,String location) {
        this.name = name;
        this.price = price;
        this.location=location;
    }

    public CommodityHelper(Integer id, String name, String price,String location) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.location=location;
    }

    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location=location;
    }
}