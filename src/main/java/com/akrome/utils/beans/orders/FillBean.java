package com.akrome.utils.beans.orders;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class FillBean {
    public final int qty;
    public final int price;
    public final ZonedDateTime ts;

    @JsonCreator
    public FillBean(
            @JsonProperty("qty") int qty,
            @JsonProperty("price") int price,
            @JsonProperty("ts") ZonedDateTime ts) {
        this.qty = qty;
        this.price = price;
        this.ts = ts;
    }
}
