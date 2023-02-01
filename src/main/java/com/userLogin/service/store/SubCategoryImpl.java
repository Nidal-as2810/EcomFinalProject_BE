package com.userLogin.service.store;



import com.userLogin.model.store.SubCategory;
import com.userLogin.repository.store.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryImpl implements SubCategoryService{
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public void create(SubCategory subCategory) {
        if(findByName(subCategory.getName())==null) {
            subCategoryRepository.create(subCategory);
        }
    }

    @Override
    public void update(SubCategory subCategory) {
        subCategoryRepository.update(subCategory);
    }

    @Override
    public void delete(Long id) {
        subCategoryRepository.delete(id);
    }

    @Override
    public void deleteByCategoryId(Long categoryId) {
        subCategoryRepository.deleteByCategoryId(categoryId);
    }

    @Override
    public List<SubCategory> getAll() {
        return subCategoryRepository.getAll();
    }

    @Override
    public List<SubCategory> getByCategoryId(Long categoryId) {
        return subCategoryRepository.getByCategoryId(categoryId);
    }

    @Override
    public SubCategory findByName(String subCategoryName) {
        return subCategoryRepository.findByName(subCategoryName);
    }
}
