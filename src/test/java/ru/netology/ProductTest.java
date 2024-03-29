package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ShopRepository;

public class ProductTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(11, "Product1", 500);
    Product product2 = new Product(22, "Product 2", 80_000);
    Product product3 = new Product(33, "Product 3", 40_000);
    Product product4 = new Product(44, "Product 4", 20_000);
    Product product5 = new Product(55, "Product 5", 100);
    Product product6 = new Product(66, "Product 6", 9500);

    @BeforeEach
    public void setup() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
    }

    @Test
    public void shouldExceptionRemoveById() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(15);
        });
    }

    @Test
    public void removeId() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(11);

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
