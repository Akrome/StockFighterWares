package com.akrome.utils.beans.orders;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.Collection;

public class OrderResponseBean {
    public final boolean ok;
    public final String symbol;
    public final String direction;
    public final int originalQty;
    public final int qty;
    public final int price;
    public final String type;
    public final int id;
    public final String account;
    public final ZonedDateTime ts;
    public final Collection<FillBean> fills;
    public final int totalFilled;
    public final boolean open;
    public final String error;

    @JsonCreator
    public OrderResponseBean(
            @JsonProperty("ok") boolean ok,
            @JsonProperty("symbol") String symbol,
            @JsonProperty("direction") String direction,
            @JsonProperty("originalQty") int originalQty,
            @JsonProperty("qty") int qty,
            @JsonProperty("price") int price,
            @JsonProperty("type") String type,
            @JsonProperty("id") int id,
            @JsonProperty("account") String account,
            @JsonProperty("ts") ZonedDateTime ts,
            @JsonProperty("fills") Collection<FillBean> fills,
            @JsonProperty("totalFilled") int totalFilled,
            @JsonProperty("open") boolean open) {
        this.ok = ok;
        this.symbol = symbol;
        this.direction = direction;
        this.originalQty = originalQty;
        this.qty = qty;
        this.price = price;
        this.type = type;
        this.id = id;
        this.account = account;
        this.ts = ts;
        this.fills = fills;
        this.totalFilled = totalFilled;
        this.open = open;
        this.error = null;
    }

    @JsonCreator
    public OrderResponseBean (
            @JsonProperty("ok") boolean ok,
            @JsonProperty("error") String error) {
        this.ok = ok;
        this.symbol = null;
        this.direction = null;
        this.originalQty = 0;
        this.qty = 0;
        this.price = 0;
        this.type = null;
        this.id = 0;
        this.account = null;
        this.ts = null;
        this.fills = null;
        this.totalFilled = 0;
        this.open = false;
        this.error = error;
    }


}
