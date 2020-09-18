package ru.geekbrains.SpringMVC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.SpringMVC.model.Product;
import ru.geekbrains.SpringMVC.repositories.ProductRepository;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){ this.productRepository = productRepository;}

    public List<Product>getAllProducts(){return productRepository.getAllProducts();}

    public Product getProductById(Long id){return productRepository.getProductById( id );}

    public void addProduct(Product product){productRepository.add( product );}
}
