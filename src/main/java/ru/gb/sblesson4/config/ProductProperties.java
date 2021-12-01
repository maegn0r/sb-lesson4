package ru.gb.sblesson4.config;



import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.gb.sblesson4.entity.Product;


import java.util.List;

@Configuration
@ConfigurationProperties("shop.properties")
@Getter
@Setter
public class ProductProperties {
    private List<Product> products;
}
