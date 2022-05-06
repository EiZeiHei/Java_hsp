package com.List;

public record Book(String name, double price, String author) {

    @Override
    public String toString() {
        return "Book name: " + name + "\tprice: " + price + "\tauthor: " + author;
    }
}
