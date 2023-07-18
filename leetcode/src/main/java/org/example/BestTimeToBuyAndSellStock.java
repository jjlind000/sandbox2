package org.example;

import java.util.Arrays;
import java.util.Date;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/830259150/
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args)
    {
        maxProfit(new int[]{7,1,5,3,6,4});
        maxProfit(new int[]{7,6,4,3,1});
    }

    public static boolean maxProfit(int[] prices) {
        long start = new Date().getTime();
        //method 1 - ok
        boolean b = false;
        int maxProfit = 0;
        //method 1
        int min = Integer.MAX_VALUE;
        int max = 0;
        int profit;
        for (int price : prices) {
            if (price < min)
                min = price;
            if (price > max)
                max = price;
           // is it profitable?
            profit = price - min;
            if (profit > 0)
            {
                System.out.printf("profitable: price %d, min %d, profit %d%n", price, min, price - min);
                if (profit > maxProfit) {
                    System.out.printf("new maxprofit %d (previous %d): price %d, min %d, profit %d%n", profit, maxProfit, price, min, price - min);
                    maxProfit = profit;
                }
                else
                {
                    System.out.printf("maxprofit still %d for price %d, min %d, profit %d%n", profit, maxProfit, price, min, price - min);
                }
            }
        }

        //maxProfit = most - least;
        //System.out.printf("least %d most %d profit %d%n", least, most, maxProfit);


        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, result %d, took %sms %n", Arrays.toString(prices), maxProfit, elapsed);
        return b;
    }
}
