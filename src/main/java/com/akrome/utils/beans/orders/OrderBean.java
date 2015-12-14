package com.akrome.utils.beans.orders;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderBean {
    public final String account;
    public final String venue;
    public final String stock;
    public final int price;
    public final int qty;
    public final String direction;
    public final String orderType;

    @JsonCreator
    public OrderBean(
            @JsonProperty("account") String account,
            @JsonProperty("venue") String venue,
            @JsonProperty("stock") String stock,
            @JsonProperty("price") int price,
            @JsonProperty("qty") int qty,
            @JsonProperty("direction") String direction,
            @JsonProperty("orderType")  String orderType) {
        this.account = account;
        this.venue = venue;
        this.stock = stock;
        this.price = price;
        this.qty = qty;
        this.direction = direction;
        this.orderType = orderType;
    }
}
