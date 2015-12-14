package com.akrome.levels;

import com.akrome.utils.beans.orders.Direction;
import com.akrome.utils.beans.orders.OrderBean;
import com.akrome.utils.beans.orders.OrderType;
import com.akrome.utils.client.routes.OrderRoutes;
import com.akrome.utils.client.routes.VenueRoutes;
import com.google.inject.Inject;

public class Level1 {
    static final String ACCOUNT = "";
    static final String STOCK = "";
    static final String VENUE = "";

    @Inject
    Checks checks;

    @Inject
    OrderRoutes orderRoutes;

    public void run() throws Exception {
        checks.checkApiIsUp();
        checks.checkVenueExists(VENUE);
        checks.checkStockExistsInVenue(VENUE, STOCK);

        OrderBean orderBean = new OrderBean(ACCOUNT, VENUE, STOCK, 0, 100, Direction.BUY, OrderType.LIMIT);
        System.out.println(orderRoutes.postOrder(orderBean));
    }

}
