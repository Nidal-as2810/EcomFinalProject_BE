package com.userLogin.controller;


import com.userLogin.model.store.SubCategory;
import com.userLogin.service.store.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategory")
@CrossOrigin
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping("/create")
    public void create(@RequestBody SubCategory subCategory){
        subCategoryService.create(subCategory);
    }

    @PutMapping("/update")
    public void update(@RequestBody SubCategory subCategory){
        subCategoryService.update(subCategory);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        subCategoryService.delete(id);
    }

    @DeleteMapping("/deleteByCategory/{categoryId}")
    public void deleteByCategoryId(@PathVariable Long categoryId){
        subCategoryService.deleteByCategoryId(categoryId);
    }

    @GetMapping("/getAll")
    public List<SubCategory> getAll(){
        return subCategoryService.getAll();
    }

    @GetMapping("/getByCategoryId/{categoryId}")
    public List<SubCategory> getByCategoryId(@PathVariable Long categoryId){
        return subCategoryService.getByCategoryId(categoryId);
    }
}
