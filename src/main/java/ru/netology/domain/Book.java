package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book(int id, String title, int cost, String author) {
        super(id, title, cost);
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (author.contains(search)) {
            return true;
        }
        return false;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
