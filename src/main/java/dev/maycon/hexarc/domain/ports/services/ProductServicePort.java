package dev.maycon.hexarc.domain.ports.services;

import dev.maycon.hexarc.domain.dto.StockDTO;
import dev.maycon.hexarc.domain.dto.ProductDTO;
import javassist.NotFoundException;

import java.util.List;

public interface ProductServicePort {

    List<ProductDTO> getProducts();
    void create(ProductDTO productDTO);
    void updateStock(String sku, StockDTO stockDTO) throws NotFoundException;
}
