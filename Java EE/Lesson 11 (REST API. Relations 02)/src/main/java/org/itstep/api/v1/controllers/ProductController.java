package org.itstep.api.v1.controllers;

import org.itstep.api.v1.dto.ProductDto;
import org.itstep.api.v1.request.ProductRequest;
import org.itstep.entities.Product;
import org.itstep.repositories.CategoriesRepository;
import org.itstep.repositories.ProductsRepository;
import org.itstep.utils.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductsRepository productsRepos;
    private final CategoriesRepository categoriesRepos;

    public ProductController(ProductsRepository productsRepos, CategoriesRepository categoriesRepos) {
        this.productsRepos = productsRepos;
        this.categoriesRepos = categoriesRepos;
    }

    @GetMapping("")
    public List<ProductDto> products() {
        return convertToProductsDto(productsRepos.findAll());
    }

    @PostMapping("")
    public ProductDto create(@RequestBody ProductRequest prod) {
        var createdProduct = ObjectMapperUtils.map(prod, Product.class);
        var category = categoriesRepos.findById(prod.getCategoryId()).orElse(null);
        createdProduct.setCategory(category);

        var result = productsRepos.save(createdProduct);
        return ObjectMapperUtils.map(result, ProductDto.class);
    }

    private List<ProductDto> convertToProductsDto(Collection<Product> products) {
        return ObjectMapperUtils.mapAll(products, ProductDto.class);
    }
}
