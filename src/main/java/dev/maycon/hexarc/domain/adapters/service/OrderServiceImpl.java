package dev.maycon.hexarc.domain.adapters.service;

import dev.maycon.hexarc.domain.Product;
import dev.maycon.hexarc.domain.dto.StockDTO;
import dev.maycon.hexarc.domain.dto.ProductDTO;
import dev.maycon.hexarc.domain.ports.services.ProductServicePort;
import dev.maycon.hexarc.domain.ports.repositories.ProductRepositoryPort;
import javassist.NotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderServiceImpl implements ProductServicePort {

    private final ProductRepositoryPort repository;

    public OrderServiceImpl(ProductRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void create(ProductDTO productDTO) {
        Product p = new Product(productDTO);
        this.repository.saveProduct(p);
    }
    @Override
    public List<ProductDTO> getProducts() {
        List<Product> products = this.repository.findAllProducts();
        List<ProductDTO> list = products.stream().map(Product::toProdutoDTO).collect(Collectors.toList());
        return list;
    }


    @Override
    public void updateStock(String sku, StockDTO stockDTO) throws NotFoundException {
    Product p = this.repository.getProductBySku(sku);
    if(Objects.isNull(p)) {
        throw new NotFoundException("Produto nao encontrado");
    }
    p.atualizarEstoque(stockDTO.getQuantity());
    this.repository.saveProduct(p);
    }
}
