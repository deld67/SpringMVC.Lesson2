package ru.geekbrains.SpringMVC.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.SpringMVC.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
    }

    public List<Product> getAllProducts(){
        return Collections.unmodifiableList( products );
    }

    public Product getProductById(Long id){
        for (Product p: products) {
            if (p.getId().equals( id )){
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }

    private Long getMaxID(){
        Long maxId = (long) 0;
        for (Product p: products) {
            if (p.getId() > maxId){maxId = p.getId();}
        }
        return maxId;
    }

    public void add(Product product){
        product.setId( getMaxID()+1 );
        products.add( product );
    }
}
