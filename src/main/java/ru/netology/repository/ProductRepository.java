package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepository {

    public ProductRepository() {}

    private Product[] items = new Product[0];

    //save
    public void save(Product item) {

        int length = items.length + 1;
        Product[] tmp = new Product[length];
//        for (int i = 0; i < items.length; i++) {
//            tmp[i] = items[i];
//        }
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    //findAAll
    public Product[] findAll() {
        return items;
    }


}
