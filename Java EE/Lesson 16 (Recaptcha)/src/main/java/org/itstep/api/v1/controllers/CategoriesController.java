package org.itstep.api.v1.controllers;

import org.itstep.api.v1.dto.CategoryDto;
import org.itstep.api.v1.dto.ProductDto;
import org.itstep.entities.Category;
import org.itstep.entities.Product;
import org.itstep.repositories.CategoriesRepository;
import org.itstep.repositories.ProductsRepository;
import org.itstep.utils.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {
    private final CategoriesRepository categoriesRepos;

    public CategoriesController(CategoriesRepository categoriesRepos) {
        this.categoriesRepos = categoriesRepos;
    }

    @GetMapping("")
    public List<CategoryDto> categories() {
        var all = categoriesRepos.findAll();
        return convertToCategoriesDto(all);
    }

    private List<CategoryDto> convertToCategoriesDto(Collection<Category> categories) {
        return ObjectMapperUtils.mapAll(categories, CategoryDto.class);
    }
}
