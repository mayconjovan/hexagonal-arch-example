package dev.maycon.hexarc.domain.ports.repositories;

import dev.maycon.hexarc.domain.Product;

import java.util.List;

public interface ProductRepositoryPort {

    List<Product> findAllProducts();
    Product getProductBySku(String sku);
    void saveProduct(Product product);
}
