package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {

    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {

            if (Product.matches(product, text)) {
                result = calc(result, product);
            } else {
                if (product instanceof Book) {
                    if (Book.matches(product, text)) {
                        result = calc(result, product);
                    }
                }
                if (product instanceof Smartphone) {
                    if (Smartphone.matches(product, text)) {
                        result = calc(result, product);
                    }
                }
            }
        }
        return result;
    }

    public Product[] calc(Product[] result1, Product product) {
        int length = result1.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < result1.length; i++) {
            tmp[i] = result1[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        result1 = tmp;
        return result1;
    }
}
