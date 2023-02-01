package com.userLogin.model.store;


import com.userLogin.model.store.response.CategoryResponse;

import java.util.List;

public class Category {
    private Long id;
    private String name;
    private String nameAr;
    private String nameHe;

    public Category(Long id, String name, String nameAr, String nameHe) {
        this.id = id;
        this.name = name;
        this.nameAr = nameAr;
        this.nameHe = nameHe;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameHe() {
        return nameHe;
    }

    public void setNameHe(String nameHe) {
        this.nameHe = nameHe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryResponse toCategoryResponse(List<SubCategory> subs){
        return new CategoryResponse(
                this.id,
                this.name,
                this.nameAr,this.nameHe,
                subs
        );
    }
}
