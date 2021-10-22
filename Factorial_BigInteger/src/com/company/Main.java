package com.company;

import java.math.*;

public class Main {

    public static void main(String[] args) {
		System.out.println(factorial(15));
    }

    public static BigInteger factorial(int value) {
        BigInteger num = BigInteger.valueOf(1);

        for(int i = 2; i <= value; ++i)
        {
            BigInteger x = BigInteger.valueOf(i);
            num = num.multiply(x);
        }

        return num; // your implementation here
    }
}
