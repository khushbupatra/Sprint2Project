package com.nisum.model;

public class Product {
    private Integer productID;
    private String name;
    private String description;
    private double price;
    private String sku;

    public Product() {}

    public Product(Integer productID, String name, String description,
                   double price, String sku) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.sku = sku;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}