package com.ThreadMethodExercise;

import static java.lang.Thread.sleep;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadSon());

        for (int i = 0; i < 10; i++) {
            System.out.println("hi");
            sleep(1000);

            if (i == 4) {
                thread.start();
                thread.join();
            }
        }
    }
}
