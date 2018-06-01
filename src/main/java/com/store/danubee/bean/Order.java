package com.store.danubee.bean;

import java.util.Date;
import java.util.Map;

/**
 * Holds the purchased/ordered items.
 *
 * @author rburawes
 */
public class Order {

    /**
     * Uniquely identifies the order.
     */
    private long id;

    /**
     * The order name.
     */
    private String name;

    /**
     * Notes, any reminders or text related
     * to the order.
     */
    private String comment;

    /**
     * Date of order/transaction.
     */
    private Date orderDate;

    /**
     * The products/items associated with
     * this order.
     */
    private Map<OrderItem, Integer> items;

    /**
     * Total amount of order.
     */
    private double totalAmount;

    public Order() {
    }

    public Order(long id, String name, String comment, Date orderDate, Map<OrderItem, Integer> items, double totalAmount) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.orderDate = orderDate;
        this.items = items;
        this.totalAmount = totalAmount;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Map<OrderItem, Integer> getItems() {
        return items;
    }

    public void setItems(Map<OrderItem, Integer> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
