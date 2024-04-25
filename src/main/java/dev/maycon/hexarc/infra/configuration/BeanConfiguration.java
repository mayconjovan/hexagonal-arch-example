package dev.maycon.hexarc.infra.configuration;

import dev.maycon.hexarc.domain.adapters.service.OrderServiceImpl;
import dev.maycon.hexarc.domain.ports.services.ProductServicePort;
import dev.maycon.hexarc.domain.ports.repositories.ProductRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ProductServicePort service(ProductRepositoryPort productRepositoryPort) {
        return new OrderServiceImpl(productRepositoryPort);
    }
}
