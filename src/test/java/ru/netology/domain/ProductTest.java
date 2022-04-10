package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Smartphone item1 = new Smartphone(1, "Linux. Смартфон PinePhone", 15000, "PINE64");
    Smartphone item2 = new Smartphone(2, "Смартфон PinePhone PRO", 20000, "PINE64");
    Smartphone item3 = new Smartphone(3, "Смартфон Fairphone", 57000, "Fairphone");
    Book item4 = new Book(4, "Книга Just for fun", 1500, "Линус Торвальдс");
    Book item5 = new Book(5, "Книга UNIX изнутри", 1200, "Ю. Вахалия");
    Book item6 = new Book(6, "Linux. Книга Операционная система UNIX", 1000,"Андрей Робачевский");

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    @Test
    public void shouldSaveEmpty() {

        repo.save(item4);

        Product[] expected = new Product[]{item4};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSave() {

        repo.save(item1);
        repo.save(item4);

        Product[] expected = new Product[]{item1, item4};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddEmpty() {

        manager.add(item1);
        manager.add(item4);

        Product[] expected = new Product[]{item1, item4};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAdd() {

        manager.add(item1);
        manager.add(item4);

        Product[] expected = new Product[]{item1, item4};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.removeById(3);

        Product[] expected = new Product[]{item1, item2, item4};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByFromOneElement() {

        repo.save(item2);

        Product[] expected = {item2};
        Product[] actual = manager.searchBy("Смартфон PinePhone PRO");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFromSeveralElements() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item6);

        Product[] expected = {item6};
        Product[] actual = manager.searchBy("Linux. Книга Операционная система UNIX");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByMultiSearch() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item6);

        Product[] expected = {item1, item6};
        Product[] actual = manager.searchBy("Linux");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNoMatches() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item5);
        repo.save(item6);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Смартфон Fairphone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByEmptyArray() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("");

        assertArrayEquals(expected, actual);
    }
    
}