package com.akrome.utils.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StockBean {
    public final String name;
    public final String symbol;

    @JsonCreator
    public StockBean(
            @JsonProperty("name") String name,
            @JsonProperty("symbol") String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}
