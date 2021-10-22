package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        DynamicArray<String> ss = new DynamicArray<>();
        ss.add("Ron");
        ss.add("Sad");
        ss.add("Mad");
        ss.add("Tad");
        ss.add("Pad");
        ss.add("Dad");
        ss.add("Bad");

        System.out.println(ss.get(3));
        System.out.println("***************************");

        ss.remove(2);

        for (int i = 0; i < 6; ++i) {
            System.out.println(ss.get(i));
        }
    }

    public static class DynamicArray<T> {
        private T[] arr = (T[]) new Object[10];
        private int index = 0;

        public void add(T el) {
            if(index > arr.length - 1) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }
            arr[index] = el;
            ++index;
        }

        public void remove(int indexVal) {
            System.arraycopy(arr, indexVal+1, arr, indexVal, arr.length -1-indexVal);
        }

        public T get(int x) {
            return arr[x];
        }
    }
}
