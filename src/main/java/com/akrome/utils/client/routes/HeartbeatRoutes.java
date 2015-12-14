package com.akrome.utils.client.routes;

import com.akrome.utils.beans.HeartbeatBean;
import com.akrome.utils.client.Paths;
import com.google.inject.Inject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Optional;

public class HeartbeatRoutes {
    @Inject
    Client client;

    public Optional<Boolean> isApiUp() {
        WebTarget webtarget = client.target(Paths.getHeartbeatPath());
        Response response = webtarget.request().get();
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            return Optional.empty();
        }
        else {
            HeartbeatBean heartbeatBean = response.readEntity(HeartbeatBean.class);
            return Optional.of(heartbeatBean.ok);
        }
    }
}
