package com.store.danubee.bean;

import java.util.Set;

import com.store.danubee.bean.constant.PromoType;

/**
 * Hold promotion and product sale details.
 */
public class Promotion {

    /**
     * The unique identintier for promotion.
     */
    private long id;

    /**
     * The promotion name.
     */
    private String name;

    /**
     * The promotion label.
     */
    private String description;

    /**
     * The type of promotion that will be used.
     */
    private PromoType type;

    /**
     * Applicable for {@link PromoType#FREE_ITEM} promotions.
     */
    private int freeItemQty;

    /**
     * Applicable for {@link PromoType#DISCOUNT} promotions.
     */
    private double discount;

    /**
     * List of products that can be availed using this
     * promotion.
     */
    private Set<Product> availableProducts;

    public Promotion(){}

    /**
     * Constructor for {@link PromoType#FREE_ITEM} promotions.
     * @param id
     * @param name
     * @param description
     * @param type
     * @param freeItemQty
     * @param availableProducts
     */
    public Promotion(long id, String name, String description, PromoType type, int freeItemQty, Set<Product> availableProducts){
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.freeItemQty = freeItemQty;
        this.availableProducts = availableProducts;
    }

    /**
     * Constructor for {@link PromoType#DISCOUNT} promotions.
     * @param id
     * @param name
     * @param description
     * @param type
     * @param discount
     * @param availableProducts
     */
    public Promotion(long id, String name, String description, PromoType type, double discount, Set<Product> availableProducts){
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.discount = discount;
        this.availableProducts = availableProducts;
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

    public PromoType getType() {
        return type;
    }

    public void setType(PromoType type) {
        this.type = type;
    }

    public int getFreeItemQty() {
        return freeItemQty;
    }

    public void setFreeItemQty(int freeItemQty) {
        this.freeItemQty = freeItemQty;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Set<Product> getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(Set<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }
}
