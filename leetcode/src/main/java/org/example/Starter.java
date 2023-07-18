package org.example;

import java.util.Date;

//
public class Starter {

    public static void main(String[] args)
    {
//        int start = (int) Math.pow(10, 2-1);
//        int end = (int) Math.pow(10, 2) - 1;
//        System.out.println("start = " + start);
//        System.out.println("end = " + end);
//        String s = "12";
//        System.out.println(Arrays.toString(s.split("")));

    }

    public static boolean foo(String s, String t) {
        long start = new Date().getTime();
        boolean b = false;
        //method 1




        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, %s, result %b, took %sms %n", s, t, b, elapsed);
        return b;
    }
}
