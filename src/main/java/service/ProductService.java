package service;

import model.Product;

import java.util.List;
import java.util.Scanner;

public interface ProductService {
    void findAllProduct();
    void findByName(Scanner scanner);
    void insProduct(Scanner scanner);
    void display(List<Product> products);
}
