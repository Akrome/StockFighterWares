package com.akrome.levels;

import com.akrome.utils.beans.venues.VenueCollectionBean;
import com.akrome.utils.beans.venues.VenueStocksBean;
import com.akrome.utils.client.routes.HeartbeatRoutes;
import com.akrome.utils.client.routes.VenueRoutes;
import com.google.inject.Inject;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

public class Checks {
    @Inject
    HeartbeatRoutes heartbeatRoutes;

    @Inject
    VenueRoutes venueRoutes;

    public void checkApiIsUp() throws Exception {
        if (!heartbeatRoutes.isApiUp().orElse(false)) {
            throw new  Exception("Api is down");
        }
    }

    public void checkVenueExists(String venue) throws Exception {
        VenueCollectionBean venueCollectionBean = venueRoutes.getVenues().orElseThrow(() -> new Exception("Can't get list of venues"));
        if (venueCollectionBean.venues.stream().noneMatch(venueBean -> venueBean.venue.equals(venue))) {
            throw new Exception("Venue is missing");
        }
    }

    public void checkStockExistsInVenue(String venue, String stockSymbol) throws Exception {
        VenueStocksBean venueStocksBean = venueRoutes.getStocksOnVenue(venue).orElseThrow(() -> new Exception("Can't get list of stocks on venue"));
        if (venueStocksBean.symbols.stream().noneMatch(stockBean -> stockBean.symbol.equals(stockSymbol))) {
            throw new Exception("Symbol is missing on the venue");
        }
    }
}
