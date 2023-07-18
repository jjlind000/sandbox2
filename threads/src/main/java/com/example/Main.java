package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        f0();
    }

    private static void f0() throws InterruptedException {


        final List<String> l = new ArrayList<>();

        final List<Runnable> runnables = new ArrayList<>();

        for (int i = 0 ; i<5000;i++)
        {
            final int ii=i;
            runnables.add(new Runnable() {
                @Override
                public void run() {
                    if (ii%2 == 0)
                        l.add(String.valueOf(ii));
                    else
                        l.remove(String.valueOf(ii));
                    System.out.println("done " + ii);
                }
            });
        }

        try(ExecutorService es = Executors.newFixedThreadPool(100)) {
            runnables.stream().forEach(r -> es.execute(r));
            Thread.sleep(1000);
            l.stream().forEachOrdered(i -> System.out.printf("i = %s;", i));
            es.shutdown();
        }

        System.out.printf("%nl.size() = " + l.size());

    }

    private static void f1() throws InterruptedException {
        Runnable r1 = () -> System.out.println("Hello world1!");
        Runnable r2 = () -> System.out.println("Hello world2!");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t2.join();
        System.out.println("done");
    }



}