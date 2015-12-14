package com.akrome.utils.beans.venues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.akrome.utils.beans.StockBean;

import java.util.Collection;

public class VenueStocksBean {
    public final boolean ok;
    public final Collection<StockBean> symbols;

    @JsonCreator
    public VenueStocksBean(
            @JsonProperty("ok") boolean ok,
            @JsonProperty("symbols") Collection<StockBean> symbols) {
        this.ok = ok;
        this.symbols = symbols;
    }
}
