package com.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public record Book(String name, int price) {

    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘20年", 5);
        books[3] = new Book("java从入门到放弃~", 300);

        //价钱从低到高
        System.out.println("\n价钱从低到高");
        Arrays.sort(books, Comparator.comparingInt(o -> o.price));

        for (Book book : books) {
            System.out.println(book.toString());
        }

        System.out.println("\n价钱从高到低");
        //价钱从高到低
        Arrays.sort(books, (o1, o2) -> o2.price - o1.price);

        for (Book book : books) {
            System.out.println(book.toString());
        }

        System.out.println("\n书名从短到长");
        //书名从短到长
        Arrays.sort(books, Comparator.comparingInt(o -> o.name.length()));

        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    @Override
    public String toString() {
        return "Book name: " + name + "\tprice: " + price;
    }
}
