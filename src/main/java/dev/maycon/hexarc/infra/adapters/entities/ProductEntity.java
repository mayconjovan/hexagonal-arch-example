package dev.maycon.hexarc.infra.adapters.entities;

import dev.maycon.hexarc.domain.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "produto")
public class ProductEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String name;
    private Double price;
    private int quantity;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String sku, String name, Double price, int quantity) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductEntity(Product other) {
        this.sku = other.getSku();
        this.name = other.getNome();
        this.price = other.getPreco();
        this.quantity = other.getQuantidade();
    }

    public void updateProduct(Product p) {
        this.sku = p.getSku();
        this.name = p.getNome();
        this.price = p.getPreco();
        this.quantity = p.getQuantidade();
    }

    public Product toProduct() {
        return new Product(this.id, this.sku, this.name, this.price, this.quantity);
    }

}
