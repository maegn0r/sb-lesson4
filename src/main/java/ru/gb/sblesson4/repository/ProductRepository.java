package ru.gb.sblesson4.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.sblesson4.config.ProductProperties;
import ru.gb.sblesson4.entity.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductRepository {
    List<Product> products = new ArrayList<>();
    private final ProductProperties productProperties;

    @PostConstruct
    private void init() {
        products.addAll(productProperties.getProducts());
    }

    public Product addProduct (Product product){
        products.add(product);
        product.setId(products.size() - 1);
        return Product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .cost(product.getCost())
                .build();
    }

    public Product editProduct(Product product){
        return products.set(product.getId(), product);
    }

    public Optional<Product> findById(int id) {
        if (id < products.size()){
            return Optional.of(products.get(id));
        } else {
            return Optional.empty();
        }
    }

    public Iterable<Product> findAll() {
        return new ArrayList<>(products);
    }

    public long count() {
        return products.size();
    }

    public void deleteById(int id){
        if (id < products.size()){
            products.remove(id);
        }
    }
}
