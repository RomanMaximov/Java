package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String text = "daa";

        if(palindrom(text))
            System.out.println(true);
        else
            System.out.println(false);
    }

    public static boolean palindrom(String text)
    {
        String temp = new StringBuilder(text).reverse().toString();
        if(!text.equals(temp))
            return false;
        return true;
    }
}
