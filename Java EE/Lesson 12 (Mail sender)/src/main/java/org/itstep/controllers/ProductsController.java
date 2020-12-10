package org.itstep.controllers;

import org.itstep.entities.Product;
import org.itstep.entities.User;
import org.itstep.repositories.ProductsRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductsRepository productsRepos;

    public ProductsController(ProductsRepository productsRepos) {
        this.productsRepos = productsRepos;
    }

    @GetMapping("")
    public String index(@AuthenticationPrincipal User user,
                        Map<String, Object> model) {
        var products = new ArrayList<>();
        var result = productsRepos.findAll();
        result.forEach(products::add);

        model.put("products", products);

        return "products/index";
    }

    @GetMapping("/create")
    public String create() {
        return "products/create";
    }

    @PostMapping("/create")
    public String create(String image, String name, String description, double price) {
        productsRepos.save(new Product(name, price, image, description));
        return "redirect:/products";
    }
}
