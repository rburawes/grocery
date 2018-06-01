package com.store.danubee.util;

import java.util.Set;

import com.store.danubee.bean.OrderItem;

/**
 * Functions for string processing.
 */
public class StringUtil {

    private static final int SPACE_ADJUSTMENT = 5;

    /**
     * Finds the largest String from the collection.
     *
     * @param items
     * @return the size
     */
    public static int findLongestStr(Set<OrderItem> items) {
        int largest = 0;

        for (OrderItem item : items) {
            if (item.getProductName().length() > largest) {
                largest = item.getProductName().length();
            }
        }

        return largest;
    }

    /**
     * Generate space based on the give length or size.
     * @param size
     * @return
     */
    public static String generateSpace(int size){
        int finalSize = size + SPACE_ADJUSTMENT;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < finalSize; i++){
            sb.append(" ");
        }
        return sb.toString();
    }
}
