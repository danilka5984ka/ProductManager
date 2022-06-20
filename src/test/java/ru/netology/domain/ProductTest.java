package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Book book1 = new Book(23, "Властелин", 230, "Толкин");
    Book book2 = new Book(13, "Властелин колец", 540, "Толкин");
    Smartphone smartphone1 = new Smartphone(68, "Iphone", 7630, "Apple");
    Smartphone smartphone2 = new Smartphone(23, "Galaxy S3", 5468, "Samsung");

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    @Test
    public void shouldSaveAllProducts() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdOne() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(68);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTwo() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(68);
        repo.removeById(13);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addAllProductsOne() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Властелин");
        Product[] expected = {book1, book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addAllProductsTwo() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("колец");
        Product[] expected = {book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addAllProductThree() {


        Product[] actual = manager.searchBy("колец");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addAllProductFour() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("JG");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

}