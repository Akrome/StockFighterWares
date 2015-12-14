package com.akrome.utils.beans.orders;

public class OrderType {
    private OrderType(){}

    public final static String LIMIT = "limit";
    public final static String MARKET = "market";
    public final static String FOC = "fill-or-kill";
    public final static String IOC = "immediate-or-cancel";
}
