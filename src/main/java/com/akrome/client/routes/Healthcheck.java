package com.akrome.client.routes;

import com.google.inject.Inject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class Healthcheck {
    @Inject
    Client client;

    public final static String API_HEALTHCHECK_URL ="https://api.stockfighter.io/ob/api/heartbeat";

    public boolean isApiUp() {
        WebTarget webtarget = client.target(API_HEALTHCHECK_URL);
        Response response = webtarget.request().get();
        return response.getStatus()== Response.Status.OK.getStatusCode();
    }
}
