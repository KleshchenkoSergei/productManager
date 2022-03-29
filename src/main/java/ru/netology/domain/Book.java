package ru.netology.domain;

import org.jetbrains.annotations.NotNull;

public class Book extends Product {

    String bookName;
    String author;

    public Book() {
        super();
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public Book(int id, String name, int price, String bookName, String author) {
        super(id, name, price);
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static boolean matches(Product product, String search) {
        Book book = (Book) product;
        if (book.getAuthor().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

}
