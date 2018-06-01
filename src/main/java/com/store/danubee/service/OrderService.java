package com.store.danubee.service;

import java.util.Set;

import com.store.danubee.bean.Order;
import com.store.danubee.bean.Product;
import com.store.danubee.bean.Promotion;

/**
 * Process all things related to orders.
 */
public interface OrderService {

    /**
     * Process and validates order details.
     * @param order
     * @param product
     * @param qty
     * @param promotions
     */
    void processOrder(Order order, Product product, int qty, Set<Promotion> promotions);

    /**
     * Creates the receipt that will be given to the customer.
     * @param order
     * @return
     */
    String printReceipt(Order order);

}
