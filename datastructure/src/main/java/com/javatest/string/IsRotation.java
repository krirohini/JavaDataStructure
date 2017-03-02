package com.javatest.string;

import java.util.Scanner;

public class IsRotation {

    public static void main(String[] args) {
        System.out.println("You need to enter two strings");
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("is rotation: " + isRotation(s1, s2));
    }

    /* Assume you have a method isSubstring whick checks if one word is a 
     * substring of another. Given two strings, s1 and s2, write code to 
     * check if s2 is a rotation of s1 using only one call to isSubstring
     * (e.g. "waterbottle" is a rotation of "erbottlewat").
     */
    public static boolean isRotation(String s1, String s2) {
        if(s1.length() == 0 || s1.length() != s2.length())
            return false;

        String s1s1 = s1 + s1;
        int index = s1s1.indexOf(s2);

        return index >= 0;
    }
}