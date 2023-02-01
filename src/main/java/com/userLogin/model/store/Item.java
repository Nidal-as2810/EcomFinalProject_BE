package com.userLogin.model.store;

public class Item {
    private Long id;
    private String name;
    private  String description;
    private Float price;
    private Integer quantity = 0;
    private String unit;
    private String image;
    private Long subcategoryId;
    private String isFavourite="no";

    public Item(Long id, String name, String description, Float price, Integer quantity, String unit, String image, Long subcategoryId, String isFavourite) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.image = image;
        this.subcategoryId = subcategoryId;
        this.isFavourite = isFavourite;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(String isFavourite) {
        this.isFavourite = isFavourite;
    }

    public Item(Long id, String name, String description, Float price, Integer quantity, String unit, String image, Long subcategoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.unit = unit;
        this.image = image;
        this.subcategoryId = subcategoryId;
        this.quantity=quantityChange(quantity);
    }

    private Integer quantityChange(Integer qty){
        int quantity=0;
        if(qty!=null) {
            quantity=qty;
        }
        return this.quantity+quantity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }
}
