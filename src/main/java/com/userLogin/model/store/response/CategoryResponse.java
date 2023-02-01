package com.userLogin.model.store.response;



import com.userLogin.model.store.SubCategory;

import java.util.List;

public class CategoryResponse {
    private Long id;
    private String name;
    private String nameAr;
    private String nameHe;
    private List<SubCategory> subs;

    public CategoryResponse(Long id, String name, String nameAr, String nameHe, List<SubCategory> subs) {
        this.id = id;
        this.name = name;
        this.nameAr = nameAr;
        this.nameHe = nameHe;
        this.subs = subs;
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

    public List<SubCategory> getSubs() {
        return subs;
    }

    public void setSubs(List<SubCategory> subs) {
        this.subs = subs;
    }
}
