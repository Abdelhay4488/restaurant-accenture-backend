package de.accenture.restaurant.controller;


import de.accenture.restaurant.entity.Product;
import de.accenture.restaurant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    // we need to write all RestAPI Endpoints for all the methods which is
    // represented in the Service Class

    // Post Method

    // Post only one Product
    // @RequestBody because we will have an input Json and will be passed to the Product object
    @PostMapping("/addProduct")
    public Product addProduct (@RequestBody Product product){
        return service.saveProduct(product);
    }


    // Post list of Products
    @PostMapping("/addProducts")
    public List<Product> addProducts (@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    // Get Method
    // Get Product By Id
    @GetMapping("/productById/{id}")
    //@PathVariable is used because we need to pass the id variable as part of the url
    // you can use also @RequesParamter (check how to use it)
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    //Get Product by Name
    @GetMapping("/productByName/{title}")
    public Product findProductByName(@PathVariable String title){
        return service.getProductByname(title);
    }

    // Get a list of Products

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    // Delete Method
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

    // Put Method ( Update )
    @PutMapping("/update")
    public Product updateProduct (@RequestBody Product product){
        return service.updateProduct(product);
    }



}
