package org.example;

import java.util.*;
import java.util.stream.Collectors;

//
public class GroupAnagrams {

    public static void main(String[] args)
    {
        foo(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    public static void foo(String [] strs) {
        long start = new Date().getTime();
        //["eat","tea","tan","ate","nat","bat"]
        //create a HM, keyed by String, which is a representation of the count of each char the alphabet in the word
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs)
        {
            int[] chars = new int[26];
            for(char c: s.toCharArray())
            {
                chars[c - 'a'] += 1;
            }
            String key = Arrays.toString(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> result = map.values().stream().collect(Collectors.toList());

        long elapsed = new Date().getTime() - start;
        System.out.printf("result %s%n", result.toString());
        System.out.printf("took %sms %n", elapsed);

    }
}
