package com.ecommerce.fyp.controllers;

import com.ecommerce.fyp.controllers.model.ReSTProduct;
import com.ecommerce.fyp.controllers.model.ReSTProductImage;
import com.ecommerce.fyp.persistence.model.Product;
import com.ecommerce.fyp.persistence.model.ProductImage;
import com.ecommerce.fyp.services.ProductService;
import com.ecommerce.fyp.services.exceptions.CategoryNotFoundException;
import com.ecommerce.fyp.services.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/ecommerce/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ReSTProduct> getAll() {
        return new ArrayList<>(productService.getAll()).stream()
                .map(this::toReSTProduct)
                .collect(toList());
    }

    @GetMapping(value = "/{id}")
    public ReSTProduct getProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        return toReSTProduct(productService.getProduct(id));
    }
    @GetMapping(value = "/{category}")
    public List<ReSTProduct> getProductByCat(@PathVariable("category") String category) throws CategoryNotFoundException {
        return new ArrayList<>(productService.getProductByCat(category).stream()
                .map(this::toReSTProduct)
                .collect(toList()));
    }

    @PutMapping
    public ReSTProduct createProduct(@RequestBody Product product) {
        return toReSTProduct(productService.createProduct(product));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
    }
    @RequestMapping(value ="featuredProduct")
    public boolean isFeaturedProduct(int id) {
        return true;
    }


    @PutMapping(value = "/{id}/images")
    public ReSTProductImage createImage(@PathVariable("id") int id, @RequestBody ReSTProductImage image) throws ProductNotFoundException {
        Product product = productService.getProduct(id);
        ProductImage productImage = new ProductImage(image.getImage(), product);
        Integer imageId = productService.createImage(productImage).getId();
        ReSTProductImage savedImage = new ReSTProductImage();
        savedImage.setId(imageId);
        savedImage.setImage(image.getImage());
        return savedImage;
    }

    @DeleteMapping(value = "/{id}/images/{image}")
    public void deleteImage(@PathVariable("id") int id, @PathVariable("image") int image) {
        productService.deleteImage(image);
    }

    private ReSTProduct toReSTProduct(Product product) {
        ReSTProduct reSTProduct = new ReSTProduct();
        reSTProduct.setProductID(product.getProductID());
        reSTProduct.setDescription(product.getDescription());
        reSTProduct.setName(product.getName());
        reSTProduct.setPrice(product.getPrice());
        reSTProduct.setImages(product.getImages().stream()
                .map(this::toReSTImage)
                .collect(toList()));
        return reSTProduct;
    }

    private ReSTProductImage toReSTImage(ProductImage image) {
        ReSTProductImage reSTProductImage = new ReSTProductImage();
        reSTProductImage.setId(image.getId());
        reSTProductImage.setImage(image.getImage());
        return reSTProductImage;
    }
}



