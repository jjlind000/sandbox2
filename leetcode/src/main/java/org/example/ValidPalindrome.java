package org.example;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

//https://leetcode.com/problems/valid-palindrome/submissions/
public class ValidPalindrome {

    public static void main(String[] args)
    {
        isPalindrome("A man, a plan, a canal: Panama");
        isPalindrome("A man, a plan, a canal: Panamax");
        isPalindrome("0P");
        isPalindrome(",,,,,,,,,,,,acva");
        isPalindrome(" ");
    }

    public static boolean isPalindrome(String s) {
        long start = new Date().getTime();

/*
        //method 1
        //1. convert all uppercase letters into lowercase letters and remove all non-alphanumeric characters
        boolean b = true;
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        //2. check each end
        for (int i = 0; i < s1.length() / 2; i++) {
            if (s1.charAt(i) != s1.charAt(s1.length() - 1 - i)) {
                b = false;
                break;
            }
        }
*/
/*
        //method 2
        //1. create set of valid chars
        boolean b = true;
        char[] chars = s.toCharArray();
        Set<Integer> validcharsset = new HashSet<>();
        int a = 'a';
        int z = 'z';
        int A = 'A';
        int Z = 'Z';
        int zero = '0';
        int nine = '9';
        for (int i = a; i <= z; i++)
        {
            validcharsset.add(i);
        }
        for (int i = A; i <= Z; i++)
        {
            validcharsset.add(i);
        }
        for (int i = zero; i <= nine; i++)
        {
            validcharsset.add(i);
        }
        //2. check each valid char from lhs against next valid char from rhs
        int end = s.length();
        outer:
        for (int i = 0; ; i++)
        {
            if (i>=end)
            {
                //System.out.printf("i %d end %d break1", i, end);
                break outer;
            }

            char lhschar = s.charAt(i);
            if (!validcharsset.contains((int)lhschar))
            //if (!Character.isLetterOrDigit(lhschar))
            {
                //System.out.println("skipping lhschar = " + lhschar);
                continue;
            }
            //System.out.println("checking lhschar = " + lhschar);
            while(true)
            {
                --end;
                if (i>=end)
                {
                    //System.out.printf("i %d end %d break", i, end);
                    break outer;
                }
                char rhschar = s.charAt(end);
                System.out.println("checking rhschar = " + rhschar);
                if (!validcharsset.contains((int)rhschar)) {
                //if (!Character.isLetterOrDigit(rhschar))
                {
                    //System.out.println("skipping rhschar = " + rhschar);
                    continue;
                }
                System.out.printf("comparing %c %c %n", lhschar, rhschar);
                if (Character.toLowerCase(lhschar) != Character.toLowerCase(rhschar)) {
                    //System.out.printf("not matching: lhs %s rhs %c = %n", lhschar, rhschar);
                    b = false;
                    break outer;
                }
                else
                {
                    continue outer;
                }
            }

        }
*/
        //method 3 - use Character.isLetterOrDigit - faster?
        //1. create set of valid chars
        boolean b = true;
        char[] chars = s.toCharArray();
        Set<Integer> validcharsset = new HashSet<>();
        int a = 'a';
        int z = 'z';
        int A = 'A';
        int Z = 'Z';
        int zero = '0';
        int nine = '9';
        for (int i = a; i <= z; i++)
        {
            validcharsset.add(i);
        }
        for (int i = A; i <= Z; i++)
        {
            validcharsset.add(i);
        }
        for (int i = zero; i <= nine; i++)
        {
            validcharsset.add(i);
        }
        //2. check each valid char from lhs against next valid char from rhs
        int end = s.length();
        outer:
        for (int i = 0; ; i++)
        {
            if (i>=end)
            {
                //System.out.printf("i %d end %d break1", i, end);
                break outer;
            }

            char lhschar = s.charAt(i);
            //if (!validcharsset.contains((int)lhschar))
            if (!Character.isLetterOrDigit(lhschar))
            {
                //System.out.println("skipping lhschar = " + lhschar);
                continue;
            }
            //System.out.println("checking lhschar = " + lhschar);
            while(true)
            {
                --end;
                if (i>=end)
                {
                    //System.out.printf("i %d end %d break", i, end);
                    break outer;
                }
                char rhschar = s.charAt(end);
                System.out.println("checking rhschar = " + rhschar);
                //if (!validcharsset.contains((int)rhschar)) {
                if (!Character.isLetterOrDigit(rhschar))
                {
                    //System.out.println("skipping rhschar = " + rhschar);
                    continue;
                }
                System.out.printf("comparing %c %c %n", lhschar, rhschar);
                if (Character.toLowerCase(lhschar) != Character.toLowerCase(rhschar)) {
                    //System.out.printf("not matching: lhs %s rhs %c = %n", lhschar, rhschar);
                    b = false;
                    break outer;
                }
                else
                {
                    continue outer;
                }
            }

        }




        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, result %b, took %sms %n", s, b, elapsed);
        return b;
    }
}
