package com.example.networking;

/*
Exempel

{
  "ID": "mobilprog_k2",
  "name": "K2",
  "type": "brom",
  "company": "",
  "location": "The Karakoram range",
  "category": "",
  "size": 8611,
  "cost": 28251,
  "auxdata": {
    "wiki": "https://en.wikipedia.org/wiki/K2",
    "img": "https://en.wikipedia.org/wiki/K2#/media/File:K2_2006b.jpg"
  }

 */

import com.google.gson.annotations.SerializedName;

public class Mountain {
    @SerializedName("ID")
    private String id;
    private String name;
    private String type;
    private String company;
    private String location;
    private String category;
    @SerializedName("size")
    private int meters;
    @SerializedName("cost")
    private int feet;
    private Auxdata auxdata;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public int getMeters() {
        return meters;
    }

    public int getFeet() {
        return feet;
    }

    public Auxdata getAuxdata() {
        return auxdata;
    }
}