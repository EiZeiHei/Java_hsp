package com.Single;

public class GirlFriend {
    public static void main(String[] args) {
        Hungry hungry = Hungry.getInstance();
        System.out.println(hungry);

        Lazy lazy = Lazy.getInstance();
        System.out.println(lazy);
    }
}
