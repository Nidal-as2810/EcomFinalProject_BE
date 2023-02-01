package com.userLogin.service.store;


import com.userLogin.model.store.SubCategory;

import java.util.List;

public interface SubCategoryService {
    void create(SubCategory subCategory);
    void update(SubCategory subCategory);
    void delete(Long id);
    void deleteByCategoryId(Long categoryId);
    List<SubCategory> getAll();
    List<SubCategory> getByCategoryId(Long categoryId);
    SubCategory findByName(String subCategoryName);
}
