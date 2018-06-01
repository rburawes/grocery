package com.store.danubee.bean;

import java.util.Objects;

import com.store.danubee.bean.constant.ProductUnit;

/**
 * Holds the details about the product sold by the store.
 */
public class Product {

    /**
     * The unique product identifier.
     */
    private long id;

    /**
     * Item or product name.
     */
    private String name;

    /**
     * The product description.
     */
    private String description;

    /**
     * The price per piece of the item.
     * For bulk product this is the price per unit in the bulk.
     */
    private double price;

    /**
     * Indicates if the product is sold per piece or
     * per bulk.
     */
    private boolean bulk;

    /**
     * Indicates the unit use in the bulk product.
     * {@link ProductUnit#PIECE} is the default for products
     * not sold in bulks
     */
    private ProductUnit unit;

    public Product() {
    }

    public Product(long id, String name, String description, double price, boolean bulk, ProductUnit unit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.bulk = bulk;
        this.unit = unit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isBulk() {
        return bulk;
    }

    public void setBulk(boolean bulk) {
        this.bulk = bulk;
    }

    public ProductUnit getUnit() {
        return unit;
    }

    public void setUnit(ProductUnit unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            Product p = (Product) o;
            return Objects.equals(p.id, this.id);
        }
        return false;
    }
}
