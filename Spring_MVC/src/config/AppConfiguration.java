package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;
import service.ProductService;
import service.ProductServiceImpl;

@Configuration
public class AppConfiguration {
    @Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepositoryImpl();
    }

}
