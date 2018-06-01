package com.store.danubee.service;

import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.store.danubee.bean.Order;
import com.store.danubee.bean.OrderItem;
import com.store.danubee.bean.Product;
import com.store.danubee.bean.Promotion;
import com.store.danubee.bean.constant.ProductUnit;
import com.store.danubee.bean.constant.PromoType;

/**
 * Test things on {@link OrderService}
 */
public class OrderServiceImplTest {

    private static List<Product> products;
    private static Set<Promotion> promotions;
    private static Set<Product> promoProducts;

    /**
     * Initialises the data that will be used for testing
     *
     * @see com.store.danubee.service.OrderService#processOrder(Order, Product, int, Set)
     * and
     * @see com.store.danubee.service.OrderService#printReceipt(Order)
     */
    @BeforeClass
    public static void loadTestData() {
        Product p01 = new Product(1l, "Lays Classic", "Potato chips", 35.00, false, ProductUnit.PIECE);
        Product p02 = new Product(2l, "Harvester's Rice", "Rice", 45.00, true, ProductUnit.KILOGRAM);
        Product p03 = new Product(3l, "Philflex Electrical Wire", "Electrical supplies", 70.00, true, ProductUnit.METER);
        Product p04 = new Product(4l, "3M Double Sided Tape", "3M Strong Permanent Double Sided Super Sticky Tape Roll For Vehicle 12mm", 70.00, true, ProductUnit.PIECE);

        products = new ArrayList<>();
        products.add(p01);
        products.add(p02);
        products.add(p03);

        promoProducts = new HashSet<>();
        promoProducts.add(p03);
        promoProducts.add(p04);

        Promotion pr01 = new Promotion(1l, "Buy 1 Take 1", "Buy the product and take 1 free", PromoType.DISCOUNT, 0.20, promoProducts);
        promotions = new HashSet<>();
        promotions.add(pr01);

    }

    /**
     * Executes the tests for
     *
     * @see com.store.danubee.service.OrderService#processOrder(Order, Product, int, Set)
     * and
     * @see com.store.danubee.service.OrderService#printReceipt(Order)
     */
    @Test
    public void processOrder() {
        OrderService service = new OrderServiceImpl();
        Random rand = new Random();
        Order order = new Order(1l, "TEST_ORDER01", "This is a test order.", new Date(), new HashMap<OrderItem, Integer>(), 0);
        for (Product product : products) {
            int rndQty = rand.nextInt((5 - 1) + 1) + 1;
            service.processOrder(order, product, rndQty, promotions);
        }
        System.out.println(service.printReceipt(order));
    }
}
