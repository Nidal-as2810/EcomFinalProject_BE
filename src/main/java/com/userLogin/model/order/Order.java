package com.userLogin.model.order;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private Long id;
    private LocalDate date;
    private Long user_id;
    private Float total;

    private OrderType orderType;

    public Order(Long id, LocalDate date, Long user_id, Float total, OrderType orderType) {
        this.id = id;
        this.date = date;
        this.user_id = user_id;
        this.total = total;
        this.orderType=orderType;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Float getTotal() {
        return total;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setTotal (List<OrderItemResponse> items){
        if(this.total==null){
            this.total=0f;
        }
        for(OrderItemResponse item :items){
            this.total+= item.getTotal();
        }
    }

    public OrderResponse toOrderResponse(List<OrderItemResponse> items){
        return new OrderResponse(this.id,this.date,this.user_id,this.orderType,items);
    }
}
