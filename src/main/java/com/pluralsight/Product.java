package com.pluralsight;

public class Product {

    private String SKU ;
    private String productName;
    private double price;
    private String department;

    public String getSKU() {
        return SKU;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }



    public Product(String SKU, String productName, double price, String department) {
        this.SKU = SKU;
        this.productName = productName;
        this.price = price;
        this.department = department;


    }

}

