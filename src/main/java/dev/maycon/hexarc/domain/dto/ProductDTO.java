package dev.maycon.hexarc.domain.dto;


public class ProductDTO {
    private String sku;
    private String name;
    private Double price;
    private Integer quantity;


    public ProductDTO(String sku, String name, Double price, Integer quantity) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
}




