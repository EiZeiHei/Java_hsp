package com.Homework02;

public class Homework02 {
    public static void main(String[] args) {
        User user = new User();

        Thread user1 = new Thread(user);
        Thread user2 = new Thread(user);

        user1.start();
        user2.start();
    }
}
