package com.company;

public class Main {

    public static void main(String[] args) {
        int[] a1 = new int[]{0, 2, 2};
        int[] a2 = new int[]{1, 3};
        int[] temp = mergeArrays(a1, a2);
        for(int i = 0; i < temp.length; ++i)
            System.out.print(temp[i] + " ");

    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int [a1.length + a2.length];
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < result.length; ++i)
        {
            if (index2 >= a2.length || index1 < a1.length && a1[index1] < a2[index2]) {
                result[i] = a1[index1];
                ++index1;
            } else {
                result[i] = a2[index2];
                ++index2;
            }
        }
        return result;
    }
}
