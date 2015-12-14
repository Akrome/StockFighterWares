package com.akrome.utils.client.routes;

import com.akrome.utils.beans.venues.VenueHealthcheckBean;
import com.akrome.utils.beans.venues.VenueCollectionBean;
import com.akrome.utils.beans.venues.VenueStocksBean;
import com.akrome.utils.client.Paths;
import com.google.inject.Inject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Optional;

public class VenueRoutes {
    @Inject
    Client client;

    public Optional<VenueCollectionBean> getVenues() {
        WebTarget webtarget = client.target(Paths.getVenuesPath());
        Response response = webtarget.request().get();
        if (response.getStatus()== Response.Status.OK.getStatusCode()) {
            return Optional.of(response.readEntity(VenueCollectionBean.class));
        }
        else {
            return Optional.empty();
        }
    }

    public Optional<VenueStocksBean> getStocksOnVenue(String venue) {
        WebTarget webtarget = client.target(Paths.getVenueStocksPath(venue));
        Response response = webtarget.request().get();
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            return Optional.empty();
        }
        else {
            return Optional.of(response.readEntity(VenueStocksBean.class));
        }
    }

    public Optional<Boolean> isVenueUp(String venue) {
        WebTarget webtarget = client.target(Paths.getVenueHeartbeatPatyh(venue));
        Response response = webtarget.request().get();
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            return Optional.empty();
        }
        else {
            VenueHealthcheckBean venueHealthcheckBean = response.readEntity(VenueHealthcheckBean.class);
            return Optional.of(venueHealthcheckBean.ok);
        }
    }
}
