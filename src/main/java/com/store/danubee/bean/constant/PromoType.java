package com.store.danubee.bean.constant;

/**
 * The types promotions.
 *
 * @author rburawes
 */
public enum PromoType {

    /**
     * The price of the item will be discounted
     * by percent. e.g 20% discount
     */
    DISCOUNT("Price discount"),
    /**
     * Buy the product and you can another item
     * for free. e.g. by 1 take 1
     */
    FREE_ITEM("Take free item");

    private final String name;

    private PromoType(String s) {
        name = s;
    }

    public boolean equals(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
