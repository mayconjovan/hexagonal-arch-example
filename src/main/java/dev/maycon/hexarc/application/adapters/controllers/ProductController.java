package dev.maycon.hexarc.application.adapters.controllers;

import dev.maycon.hexarc.domain.dto.StockDTO;
import dev.maycon.hexarc.domain.dto.ProductDTO;
import dev.maycon.hexarc.domain.ports.services.ProductServicePort;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProductController {

    private final ProductServicePort service;

    public ProductController(ProductServicePort service) {
        this.service = service;
    }

    @PostMapping
    void createProduct(@RequestBody ProductDTO productDTO) {
        service.create(productDTO);
    }

    @GetMapping
    List<ProductDTO> getProducts() {
        return service.getProducts();
    }

    @PutMapping(value = "/{sku}")
    void updateStock(@PathVariable String sku, @RequestBody StockDTO stockDTO) throws NotFoundException {
        service.updateStock(sku, stockDTO);
    }

}
