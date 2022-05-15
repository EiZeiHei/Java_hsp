package com.Homework;

import org.junit.jupiter.api.Test;

public class MainTest {
    public static void main(String[] args) {
    }

    @Test
    public void test() {
        DAO<User> dao = new DAO<>();
        dao.save("1", new User(1, 18, "LA"));
        dao.save("2", new User(2, 28, "BA"));
        dao.save("3", new User(3, 38, "GA"));
        System.out.println("====save=====\n" + dao);

        System.out.println("====get=====\n" + dao.get("2"));

        dao.update("3", new User(3, 20, "MA"));
        System.out.println("====update=====\n" + dao);

        System.out.println("====list=====\n" + dao.list());

        dao.delete("2");
        System.out.println("====delete=====\n" + dao);
    }
}
