package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = {3,5,20,8,7,3,100};
        int[] arr2 = {};
        printOddNumbers(arr);
    }

    public static void printOddNumbers(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] % 2 == 1) {
                    stringBuilder.append(arr[i] + ",");
                }
        }
        int x = stringBuilder.length()-1;
        stringBuilder.deleteCharAt(x);
        System.out.println(stringBuilder);
    }
}
