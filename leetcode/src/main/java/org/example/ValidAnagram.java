package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://leetcode.com/problems/valid-anagram/submissions/828889013/
public class ValidAnagram {

    public static void main(String[] args)
    {
        validAnagram("car", "rac");
        validAnagram("car", "rat");
        validAnagram("anagram", "nagaram");
    }

    public static boolean validAnagram(String s, String t) {
        long start = new Date().getTime();
        //method 1 - ACCEPTED, VG
        boolean b = false;
        if (s.length() != t.length())
            b = false;
        else {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        Arrays.sort(schars);
        Arrays.sort(tchars);

        b=Arrays.equals(schars, tchars);
        }

        //method 2 - too slow
//        boolean b = true;
//        if (s.length() != t.length())
//            b = false;
//        else {
//            Map<Character, Long> sgrouped = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
//            Map<Character, Long> tgrouped = t.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
//            if (sgrouped.keySet().size() != tgrouped.keySet().size()) {
//                System.out.println("1 false");
//                b = false;
//            } else {
//                for (Character skey : sgrouped.keySet()) {
//                    if (!sgrouped.get(skey).equals(tgrouped.get(skey))) {
//                        System.out.println("2 false");
//                        b = false;
//                        break;
//                    }
//                }
//            }
//        }


        //method 3 - manual grouping - v good on memory, good on performance, but not the best
//        boolean b = true;
//        if (s.length() != t.length())
//            b = false;
//        else {
//            Map<Character, Integer> sgrouped = new HashMap<>();
//            Map<Character, Integer> tgrouped = new HashMap<>();
//            for (char c : s.toCharArray()) {
//                Character key = Character.valueOf(c);
//                int count = sgrouped.getOrDefault(key, 0);
//                sgrouped.put(key, ++count);
//            }
//            for (char c : t.toCharArray()) {
//                Character key = Character.valueOf(c);
//                int count = tgrouped.getOrDefault(key, 0);
//                tgrouped.put(key, ++count);
//            }
//
//            if (sgrouped.keySet().size() != tgrouped.keySet().size()) {
//                b = false;
//            } else {
//                for (Character skey : sgrouped.keySet()) {
//                    if (!sgrouped.get(skey).equals(tgrouped.get(skey))) {
//                        b = false;
//                        break;
//                    }
//                }
//            }
//        }

        // method 4 - neetcode solution
//        boolean b = true;
//        if (s.length() != t.length()) return false;
//
//        int[] store = new int[26];
//
//        for (int i = 0; i < s.length(); i++) {
//            store[s.charAt(i) - 'a']++;
//            store[t.charAt(i) - 'a']--;
//        }
//
//        for (int n : store) if (n != 0) return false;
//
//


        long elapsed = new Date().getTime() - start;
        System.out.printf("got %s, %s, result %b, took %sms %n", s, t, b, elapsed);
        return b;
    }
}
