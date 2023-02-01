package com.userLogin.repository.store;



import com.userLogin.model.store.Category;

import java.util.List;

public interface CategoryRepository {
    void create(String categoryName);
    void update(Category category);
    Category findCategoryByName(String categoryName);
    List<Category> getAllCategories();
    void deleteById(Long id);
}
