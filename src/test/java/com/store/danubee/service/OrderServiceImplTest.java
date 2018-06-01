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
    private static List<Product> products2;
    private static Set<Promotion> promotions;
    private static Set<Promotion> promotions2;
    private static Set<Product> promoProducts;
    private static Set<Product> promoProducts2;

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
        Product p05 = new Product(5l, "OMNI Flexible LED Lamp", "LED table lamp", 270.00, true, ProductUnit.PIECE);

        products = new ArrayList<>();
        products.add(p01);
        products.add(p02);
        products.add(p03);

        promoProducts = new HashSet<>();
        promoProducts.add(p03);
        promoProducts.add(p04);

        Promotion pr01 = new Promotion(1l, "20% Discount", "Buy the product and take 1 free", PromoType.DISCOUNT, 0.20, promoProducts);
        promotions = new HashSet<>();
        promotions.add(pr01);

        promoProducts2 = new HashSet<>();
        promoProducts2.add(p05);

        Promotion pr02 = new Promotion(1l, "Buy 1 Take 1", "Buy the product and take 1 free", PromoType.FREE_ITEM, 1, promoProducts2);
        promotions2 = new HashSet<>();
        promotions2.add(pr02);

        products2 = new ArrayList<>();
        products2.add(p01);
        products2.add(p02);
        products2.add(p03);
        products2.add(p05);
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
        // Create an instance of OrderService.
        OrderService service = new OrderServiceImpl();
        // Generates random number for quantity.
        Random rand = new Random();

        // Test order #1
        Order order = new Order(1l, "TEST_ORDER01", "This is a test order.", new Date(), new HashMap<OrderItem, Integer>(), 0);
        for (Product product : products) {
            int rndQty = rand.nextInt((5 - 1) + 1) + 1;
            service.processOrder(order, product, rndQty, promotions);
        }
        System.out.println(service.printReceipt(order));

        // Test order #2
        Order order2 = new Order(1l, "TEST_ORDER02", "This is a test order number 2", new Date(), new HashMap<OrderItem, Integer>(), 0);
        for (Product product : products2) {
            int rndQty = rand.nextInt((5 - 1) + 1) + 1;
            service.processOrder(order2, product, rndQty, promotions2);
        }

        System.out.println(service.printReceipt(order2));
    }
}
