package com.store.danubee.bean.constant;

/**
 * The unit that will be used by
 * the product.
 *
 * @author rburawes
 */
public enum ProductUnit {
    KILOGRAM ("Kilogram"),
    GRAM ("Gram"),
    METER ("Meter"),
    PIECE ("Piece");

    private final String name;

    private ProductUnit(String s) {
        name = s;
    }

    public boolean equals(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
