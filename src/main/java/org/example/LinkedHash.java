package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class LinkedHash {

    private static final boolean HASH_MODE = true;
    public static final int ARRAY_LENGTH = 15;
    private static final HashMap<Integer, ArrayList<Integer>> hashTable = new HashMap<>(ARRAY_LENGTH);

    public static void main(String[] args) {
        int number = 21;
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(number);
        hashTable.put(hashCode(21), tmp);
        System.out.println(find(21));
        System.out.println(addElement(2));
        System.out.println(hashTable);
        for (int i = 0; i < 15; i++){
            addElement(new Random().nextInt(110));
        }
        System.out.println(addElement(213));
        System.out.println(hashTable);
        System.out.println(addElement(12));
        System.out.println(hashTable);
        System.out.println(removeElement(2));
        System.out.println(hashTable);
        System.out.println(removeElement(213));
        System.out.println(hashTable);
    }

    public static boolean addElement(int c) {

        if (!find(c)) {
            ArrayList<Integer> list;
            if ((list = hashTable.get(hashCode(c))) != null) {
                list.add(c);
            } else {
                list = new ArrayList<>();
                list.add(c);
                hashTable.put(hashCode(c), list);
            }
            return true;
        }
        return false;
    }

    public static boolean removeElement(Integer c) {

        if (find(c)) {
            ArrayList<Integer> list;
            int hash = hashCode(c);
            if ((list = hashTable.get(hash)) != null) {

                list.remove(c);
                if (list.size() == 0)
                    hashTable.remove(hash);
                return true;
            }
        }
        return false;
    }

    public static boolean find(int c) {

        ArrayList<Integer> list;
        if ((list = hashTable.get(hashCode(c))) != null) {
            return list.contains(c);
        }

        return false;
    }

    public static int hashCode(int c) {

        int result;
        if (HASH_MODE) {
            result = 1;

            result = 31 * result + c;
        } else {
            if (hashTable.size() == 0) result = 1;
            else result = c % ARRAY_LENGTH;
        }
        return result;
    }
}