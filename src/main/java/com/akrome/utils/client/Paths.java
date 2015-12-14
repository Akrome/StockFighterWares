package com.akrome.utils.client;

public class Paths {
    static final String BASE_URL = "https://api.stockfighter.io/ob/api/";
    static final String VENUES_PATH = "venues/";
    static final String STOCKS_PATH = "stocks/";
    static final String ORDERS_PATH = "orders/";
    static final String HEARTBEAT_PATH = "heartbeat/";

    public static String getHeartbeatPath() {
        return BASE_URL+HEARTBEAT_PATH;
    }

    public static String getVenuesPath() {
        return BASE_URL+VENUES_PATH;
    }

    public static String getVenuePath(String venue) {
        return getVenuesPath()+venue+"/";
    }

    public static String getVenueHeartbeatPatyh(String venue) {
        return getVenuePath(venue)+HEARTBEAT_PATH;
    }

    public static String getVenueStocksPath(String venue) {
        return getVenuePath(venue)+STOCKS_PATH;
    }

    public static String getStockPath(String venue, String symbol) {
        return getVenueStocksPath(venue)+symbol+"/";
    }

    public static String getOrdersPath(String venue, String symbol) {return getStockPath(venue, symbol)+ORDERS_PATH; }
}
