package org.example;

import java.util.*;

public class LinearHash {
    private static final Integer QUANTITY_OF_ELEMENTS = 50;
    public static final int ARRAY_LENGTH = 15;
    private static final Integer[] HASH_TABLE = new Integer[ARRAY_LENGTH];


    public static void main(String[] args) {

        int integer = new Random().nextInt(16);
        System.out.println(addElement(integer, 0));

        for (int i = 0; i < QUANTITY_OF_ELEMENTS - 1; i++) {
            addElement(new Random().nextInt(16), 0);
        }

        System.out.println(Arrays.toString(HASH_TABLE));

        System.out.println(removeElement(integer));

        System.out.println(find(integer));

        System.out.println(Arrays.toString(HASH_TABLE));
    }

    public static boolean addElement(int value, int counter) {

        int hash = hashCode(value);
        if (HASH_TABLE[hash + counter] == null) {
            HASH_TABLE[hash + counter] = value;
            return true;
        } else {

            counter++;
            if (hash + counter >= HASH_TABLE.length)
                return false;
            if (HASH_TABLE[hash + counter] == null)
                HASH_TABLE[hash + counter] = value;
            else
                addElement(value, counter);
        }
        return false;
    }

    public static boolean removeElement(Integer value) {
        List<Integer> list = Arrays.asList(HASH_TABLE);
        try {
            int index = list
                    .stream()
                    .filter(x -> x != null
                            && x.equals(value))
                    .findFirst()
                    .get();

            if (HASH_TABLE[index] != null) {
                HASH_TABLE[index] = null;
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("No such element: " + value);
        }
        return false;
    }

    public static boolean find(int value) {

        List<Integer> list = Arrays.asList(HASH_TABLE);
        return list.contains(value);
    }

    public static int hashCode(int value) {

        return value % HASH_TABLE.length;
    }
}