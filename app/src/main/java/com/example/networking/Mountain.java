package com.example.networking;

/* Exempel

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

    public String getID() {
        if (id.equals("")) {
            return null;
        }
        else {
            return id;
        }
    }
    public String getName() {
        if (name.equals("")) {
            return null;
        }
        else {
            return name;
        }
    }
    public String getType() {
        if (type.equals("")) {
            return null;
        }
        else {
            return type;
        }
    }

    public String getCompany() {
        if (company.equals("")) {
            return null;
        }
        else {
            return company;
        }
    }

    public String getLocation() {
        if (location.equals("")) {
            return null;
        }
        else {
            return location;
        }
    }

    public String getCategory() {
        if (category.equals("")) {
            return null;
        }
        else {
            return category;
        }
    }
    public Integer getSize() {
            return meters;
    }

    public Integer getCost() {
        return feet;
    }

    public Auxdata getAuxdata() {
        return auxdata;
    }
}
