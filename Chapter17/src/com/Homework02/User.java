package com.Homework02;

public class User extends Thread{
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足，无法取出");
                    break;
                }

                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出了 1000\t"
                        + "剩余：" + money);
            }
        }

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
