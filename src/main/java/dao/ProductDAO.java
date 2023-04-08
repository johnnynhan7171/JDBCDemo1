package dao;

import model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAllProduct();
    List<Product> findByName(String name);
    int insProduct(List<Product> product);
}
