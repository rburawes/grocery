package com.store.danubee.bean;

/**
 * The item in the order.
 *
 * @author rburawes
 */
public class OrderItem {

    /**
     * Uniquely identifies the order line.
     */
    private long id;

    /**
     * The product ordered.
     */
    private long productId;

    /**
     * The name of the product ordered.
     */
    private String productName;

    /**
     * The number of product ordered.
     */
    private int qty;

    /**
     * The oriqinal price.
     */
    private double price;

    /**
     * The discount amount.
     */
    private double discount;

    /**
     * The discounted price.
     */
    private double totalPrice;

    public OrderItem(){ }

    public OrderItem(long id, long productId, String productName, int qty, double price, double discount, double totalPrice){
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.qty = qty;
        this.price = price;
        this.discount = discount;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
