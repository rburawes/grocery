package com.store.danubee.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.store.danubee.bean.Order;
import com.store.danubee.bean.OrderItem;
import com.store.danubee.bean.Product;
import com.store.danubee.bean.Promotion;
import com.store.danubee.bean.constant.PromoType;
import com.store.danubee.util.StringUtil;

/**
 * @author rburawes
 * @see com.store.danubee.service.OrderService
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final String ORDER_DATE = "Order date: ";
    private static final String ORDER_NUMBER = "Order #: ";
    private static final String QTY = "Quantity";
    private static final String ITEM = "Item";
    private static final String AMOUNT = "Amount";
    private static final String DISCOUNT = "Discount";
    private static final String TOTAL_AMOUNT = "Total Amount";
    private static final String GRAND_TOTAL = "Grand Total";

    private int lineCtr = 0;

    /**
     * @param product
     * @param promotions
     * @see com.store.danubee.service.OrderService#processOrder(Order, Product, int, Set)
     */
    @Override
    public void processOrder(Order order, Product product, int qty, Set<Promotion> promotions) {

        if (product == null) {
            return;
        }

        if (order == null) {
            return;
        }

        OrderItem item = checkOrder(product, qty, promotions);

        if (order.getItems().containsKey(item)) {
            order.getItems().put(item, order.getItems().get(item) + qty);
        } else {
            order.getItems().put(item, qty);
        }

    }

    /**
     * Validates order, check if promotion is available on the product ordered.
     *
     * @param product
     * @param qty
     * @param promotions
     * @return
     */
    private OrderItem checkOrder(Product product, int qty, Set<Promotion> promotions) {

        lineCtr++;
        double price = 0;
        double totalPrice = 0;
        double discount = 0;

        for (Promotion p : promotions) {
            if (!CollectionUtils.isEmpty(p.getAvailableProducts()) && p.getAvailableProducts().contains(product)) {
                if (p.getType().equals(PromoType.DISCOUNT)) {
                    price = qty * product.getPrice();
                    discount = price * (p.getDiscount() / 100);
                    totalPrice = price - discount;
                } else if (p.getType().equals(PromoType.FREE_ITEM)) {
                    if (qty <= p.getFreeItemQty()) {
                        price = 0;
                    } else {
                        price = (qty - p.getFreeItemQty()) * product.getPrice();
                    }
                    discount = p.getFreeItemQty() * product.getPrice();
                    totalPrice = price;
                }
            } else {
                price = product.getPrice();
                discount = 0;
                totalPrice = price * qty;
            }
        }

        return new OrderItem(lineCtr, product.getId(), product.getName(), qty, price, discount, totalPrice);

    }

    /**
     * @param order
     * @return
     * @see com.store.danubee.service.OrderService#printReceipt(Order)
     */
    @Override
    public String printReceipt(Order order) {

        int spaceSize = StringUtil.findLongestStr(order.getItems().keySet());

        StringBuffer sb = new StringBuffer(ORDER_NUMBER)
                .append(order.getId())
                .append(StringUtil.generateSpace(spaceSize - ORDER_NUMBER.length()))
                .append(ORDER_DATE)
                .append(order.getOrderDate())
                .append("\n")
                .append(QTY)
                .append(StringUtil.generateSpace(spaceSize - QTY.length()))
                .append("Item")
                .append(StringUtil.generateSpace(spaceSize - ITEM.length()))
                .append("Amount")
                .append(StringUtil.generateSpace(spaceSize - AMOUNT.length()))
                .append("Discount")
                .append(StringUtil.generateSpace(spaceSize - DISCOUNT.length()))
                .append(TOTAL_AMOUNT)
                .append("\n\n");

        double grandTotal = 0;

        for (OrderItem item : order.getItems().keySet()) {
            double total = item.getTotalPrice();
            String qty = String.format("%d", item.getQty());
            String amount = String.format("%.2f", item.getPrice());
            String discount = String.format("%.2f", item.getDiscount());
            String tot = String.format("%.2f", total);
            sb.append(qty)
                    .append(StringUtil.generateSpace(spaceSize - qty.length()))
                    .append(item.getProductName())
                    .append(StringUtil.generateSpace(spaceSize - item.getProductName().length()))
                    .append(amount)
                    .append(StringUtil.generateSpace(spaceSize - amount.length()))
                    .append(discount)
                    .append(StringUtil.generateSpace(spaceSize - discount.length()))
                    .append(tot)
                    .append("\n");
            grandTotal = grandTotal + total;
        }
        sb.append("\n")
                .append(GRAND_TOTAL)
                .append(StringUtil.generateSpace(spaceSize - GRAND_TOTAL.length()))
                .append(String.format("Php%.2f", grandTotal));

        return sb.toString();
    }

}
