package com.userLogin.controller;


import com.userLogin.model.store.Category;
import com.userLogin.model.store.response.CategoryResponse;
import com.userLogin.service.store.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create/{category}")
    public void create(@PathVariable String category){
        categoryService.create(category);
    }

    @PutMapping("/update")
    public void update(@RequestBody Category category){
        categoryService.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        categoryService.deleteById(id);
    }

    @GetMapping("/get")
    public List<CategoryResponse> getAll(){
        return categoryService.getAllCategories();
    }
}
