package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sorting {
    public static void main(String[] args) throws InterruptedException {

        f0();
    }

    private static void f0() throws InterruptedException {

        /* Task:
        1, Create a class Foo, member variables x int, y int, z char
        2, Create a list of 10 instances of X, with random values for x (0-9), y (0-9) and z ('A' to 'J')
        3, Print the list, sort the list in asc, desc, asc order, and print the sorted list



         */


        List<X> xes = IntStream.generate(() -> ThreadLocalRandom.current()
                .nextInt(10))
                .limit(10)
                .mapToObj(i -> {
            return new X(i,
                         ThreadLocalRandom.current().nextInt(10),
                         String.valueOf((char) ('A' + ThreadLocalRandom.current().nextInt(0, 10))));
        }).collect(Collectors.toList());

        Map<Integer, List<X>> grouped = xes.stream().collect(Collectors.groupingBy(e -> e.getX()));

        xes.forEach(x -> System.out.println(" = " + x.toString()));

        Comparator<X> xComparator = Comparator.comparing(X::getX).thenComparing(X::getY).reversed().thenComparing(X::getS);
        xes.sort(xComparator);
        System.out.println("sorted ===>");
        xes.forEach(x -> System.out.println(" = " + x.toString()));
        System.out.println("sorted natural ===>");
        xes.sort(Comparator.naturalOrder());
        xes.forEach(x -> System.out.println(" = " + x.toString()));
    }


    static class X implements Comparable<X>{

        int x;
        int y;
        String s;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String getS() {
            return s;
        }

        public X(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }

        @Override
        public String toString() {
            return "X{" +
                    "x=" + x +
                    ", y=" + y +
                    ", s='" + s + '\'' +
                    '}';
        }

        @Override
        public int compareTo(X o) {
            if (Integer.compare(this.x, o.x) > 0) return 1;
            if (Integer.compare(this.y, o.y) > 0) return 1;
            return this.s.compareTo(o.s);
        }
    }

}