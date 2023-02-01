package com.userLogin.model.order;

public class OrderItemResponse {
    private Long id;
    private Long itemId;
    private String name;
    private  String description;
    private Float price;
    private Integer quantity = 0;
    private String unit;
    private String image;
    private Long subcategoryId;
    private int qty;
    private Float total;

    public OrderItemResponse(Long id, Long itemId, String name, String description, Float price, Integer quantity, String unit, String image, Long subcategoryId, int qty, Float total) {
        this.id = id;
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.image = image;
        this.subcategoryId = subcategoryId;
        this.qty = qty;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getImage() {
        return image;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public int getQty() {
        return qty;
    }

    public Float getTotal() {
        return total;
    }
}
