package netology_java14;

;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RepoAndManagerTests {

    private ProductRepo repository = new ProductRepo();
    private ProductManager manager = new ProductManager(repository);


    Product first = new Book("book1", "author1", 1, 100);
    Product second = new Book("book2", "author1", 2, 200);
    Product third = new Book("book3", "author2", 3, 300);
    Product fourth = new Smartphone("phone1", "supplier1", 4, 1000);
    Product fifth = new Smartphone("phone2", "supplier2", 5, 2000);


    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void addProduct() {
        manager.add(first);
        assertArrayEquals(new Product[]{first}, repository.getItem());
    }

    @Test
    void searchBook1() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("book3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBook2() {
        setUp();

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("book2");
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchPhone2() {
        setUp();

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("phone2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchPhone1() {
        setUp();

        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("phone1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneProduct() {
        repository.save(first);

        Product[] expected = new Product[]{first};
        Product[] actual = repository.getItem();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveId() {
        repository.save(first);

        int idToRemove = 1;
        repository.delete(idToRemove);

        Product[] expected = new Product[]{};
        Product[] actual = repository.getItem();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveId2() {
        repository.save(first);
        repository.save(second);

        int idToRemove = 2;
        repository.delete(idToRemove);

        Product[] expected = new Product[]{first};
        Product[] actual = repository.getItem();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindId() {
        repository.save(first);
        repository.save(second);
        repository.save(third);


        repository.findById(1);

        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("1");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDelete() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Assertions.assertThrows(RuntimeException.class, () -> {
            repository.delete(444);
        });
        
    }
}
