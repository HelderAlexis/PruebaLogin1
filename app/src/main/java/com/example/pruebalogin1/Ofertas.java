package com.example.pruebalogin1;

public class Ofertas {

    private String title;
    private String owner;
    private double precio;
    private double star;
    private String picPath;

    public Ofertas(String title, String owner, double precio, double star, String picPath) {
        this.title = title;
        this.owner = owner;
        this.precio = precio;
        this.star = star;
        this.picPath = picPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
