package ru.netology.domain;

public class Book extends Product {

    private String bookName;
    private String author;

    public Book() {
        super();
    }

    public Book(int id, String name, int price, String bookName, String author) {
        super(id, name, price);
        this.bookName = bookName;
        this.author = author;
    }

}
