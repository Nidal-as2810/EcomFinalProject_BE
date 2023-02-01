package com.userLogin.model.order;


import com.userLogin.model.store.Item;

public class OrderItem {
    private Long id;
    private  Long order_id;
    private Long item_id;
    private Float price;
    private int qty;
    private Float total;

    public OrderItem(Long id, Long order_id, Long item_id, Float price, int qty) {
        this.id = id;
        this.order_id = order_id;
        this.item_id = item_id;
        this.price = price;
        this.qty = qty;
        this.total=price*qty;
    }

    public Long getId() {
        return id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public Float getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public Float getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public OrderItemResponse toOrderItemResponse(Item item){
        return new OrderItemResponse(this.id,this.item_id, item.getName(), item.getDescription(),this.price,null,item.getUnit(),item.getImage(),item.getSubcategoryId(),this.qty,this.total);
    }
}
