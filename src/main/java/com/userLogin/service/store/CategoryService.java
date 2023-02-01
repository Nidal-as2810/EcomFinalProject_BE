package com.userLogin.service.store;



import com.userLogin.model.store.Category;
import com.userLogin.model.store.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    void create(String categoryName);
    void update(Category category);
    Category findCategoryByName(String categoryName);
    List<CategoryResponse> getAllCategories();
    void deleteById(Long id);
}
