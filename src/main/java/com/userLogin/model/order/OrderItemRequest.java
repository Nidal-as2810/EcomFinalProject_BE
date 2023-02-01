package com.userLogin.model.order;


import com.userLogin.model.store.Item;

public class OrderItemRequest {
    private Long itemId;
    private int qty;

    public OrderItemRequest(  Long item_id, int qty) {
        this.itemId = item_id;
        this.qty = qty;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public OrderItem toOrderItem(Item item, Long order_id){
        return new OrderItem(null,order_id,this.itemId,item.getPrice(),this.qty);
    }
}
