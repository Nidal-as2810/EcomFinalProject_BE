package com.userLogin.model.store;

public class SubCategory {
    private Long id;
    private String name;
    private String nameAr;
    private String nameHe;
    private Long categoryId;

    public SubCategory(Long id, String name, String nameAr, String nameHe, Long categoryId) {
        this.id = id;
        this.name = name;
        this.nameAr = nameAr;
        this.nameHe = nameHe;
        this.categoryId = categoryId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
