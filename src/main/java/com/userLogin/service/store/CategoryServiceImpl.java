package com.userLogin.service.store;


import com.userLogin.model.store.Category;
import com.userLogin.model.store.SubCategory;
import com.userLogin.model.store.response.CategoryResponse;
import com.userLogin.repository.store.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryService subCategoryService;

    @Override
    public void create(String categoryName) {
        if(categoryRepository.findCategoryByName(categoryName)==null){
            categoryRepository.create(categoryName);
        }
    }

    @Override
    public void update(Category category) {
        categoryRepository.update(category);
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories=categoryRepository.getAllCategories();
        List<CategoryResponse> subs=new ArrayList<>();
        for(Category category : categories){
            List<SubCategory> subCategories=subCategoryService.getByCategoryId(category.getId());
            if(subCategories!=null){
                subs.add(category.toCategoryResponse(subCategories));
            }
        }
        return subs;
    }

    @Override
    public void deleteById(Long id) {
        // delete all related subs
        categoryRepository.deleteById(id);
    }
}
