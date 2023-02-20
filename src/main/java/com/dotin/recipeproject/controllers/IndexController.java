package com.dotin.recipeproject.controllers;

import com.dotin.recipeproject.model.Category;
import com.dotin.recipeproject.model.UnitOfMeasure;
import com.dotin.recipeproject.repository.CategoryRepository;
import com.dotin.recipeproject.repository.UnitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitRepository unitRepository;

    public IndexController(CategoryRepository categoryRepository, UnitRepository unitRepository) {
        this.categoryRepository = categoryRepository;
        this.unitRepository = unitRepository;
    }

    @RequestMapping({"","/","index","index.html"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOptional = unitRepository.findByDescription("Teaspoon");
        System.out.println("Cat id is : " + categoryOptional.get().getId());
        System.out.println("Unit id is : " + unitOptional.get().getId());

        return "index";
    }

}
