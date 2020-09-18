package ru.geekbrains.SpringMVC.controls;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringMVC.model.Product;
import ru.geekbrains.SpringMVC.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsControllers {
    private ProductService productService;

    public ProductsControllers(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String getAllProducts(Model model){
        model.addAttribute( "products", productService.getAllProducts() );
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product){
        productService.addProduct( product );
        return "redirect:/products/";

    }
    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model){
        model.addAttribute( "product", productService.getProductById( id ) );
        return "product";
    }

}
