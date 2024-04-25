package dev.maycon.hexarc.infra.adapters.repositories;

import dev.maycon.hexarc.domain.Product;
import dev.maycon.hexarc.domain.ports.repositories.ProductRepositoryPort;
import dev.maycon.hexarc.infra.adapters.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductRepository implements ProductRepositoryPort {

    private final SpringProductRepository repository;

    public ProductRepository(SpringProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Product> findAllProducts() {
        List<ProductEntity> products = this.repository.findAll();

        return products.stream().map(ProductEntity::toProduct).collect(Collectors.toList());
    }

    @Override
    public Product getProductBySku(String sku) {
        Optional<ProductEntity> product = repository.findBySku(sku);

        if (product.isPresent()) {
            return product.get().toProduct();
        }
        throw new RuntimeException("Produto not found");
    }

    @Override
    public void saveProduct(Product product) {
        ProductEntity productEntity;
        if (Objects.isNull(product.getCodigo())) {
            productEntity = new ProductEntity(product);
        }
        else {
            productEntity = repository.findById(product.getCodigo()).get();
            productEntity.updateProduct(product);
        }

        this.repository.save(productEntity);
    }
}
