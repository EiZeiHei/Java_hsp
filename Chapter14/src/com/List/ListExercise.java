package com.List;

import java.util.ArrayList;
import java.util.List;

public class ListExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("金瓶梅", 100, "Unkonwn"));
        list.add(new Book("少年阿宾", 10, "Unkonwn"));
        list.add(new Book("Java", 300, "Unkonwn"));

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book1.price() > book2.price()) {
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }

        for (Object o : list) {
            System.out.println(o);
        }

    }
}
