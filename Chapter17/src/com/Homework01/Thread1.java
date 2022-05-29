package com.Homework01;

public class Thread1 extends Thread {
    private boolean loop = true;

    @Override
    @SuppressWarnings({"all"})
    public void run() {
        while (loop) {
            System.out.println((int) (Math.random() * 100 + 1));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Thread1 exits");
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
