package dev.maycon.hexarc.domain;

import dev.maycon.hexarc.domain.dto.ProductDTO;

public class Product {

    private Long codigo;
    private String sku;
    private String nome;
    private Double preco;
    private Integer quantidade;

    public Product(){}

    public Product(Long codigo, String sku, String nome, Double preco, Integer quantidade) {
        this.codigo = codigo;
        this.sku = sku;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Product(ProductDTO productDTO){
        this.sku = productDTO.getSku();
        this.nome = productDTO.getName();
        this.preco = productDTO.getPrice();
        this.quantidade = productDTO.getQuantity();
    }

    public void atualizarEstoque(int quantidade){
        this.quantidade = quantidade;
    }

    public ProductDTO toProdutoDTO() {
        return new ProductDTO(this.sku, this.nome, this.preco, this.quantidade);
    }
}
