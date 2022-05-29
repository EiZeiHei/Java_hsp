package com.Homework01;

import java.util.Scanner;

public class Thread2 extends Thread {
    private final Thread1 thread1;
    private final Scanner scanner = new Scanner(System.in);

    public Thread2(Thread1 thread1) {
        this.thread1 = thread1;
    }

    @Override
    public void run() {
        while (true) {
            char key = scanner.next().charAt(0);
            if (key == 'Q') {
                thread1.setLoop(false);
                System.out.println("Thread2 exits");
                break;
            }
        }
    }
}
