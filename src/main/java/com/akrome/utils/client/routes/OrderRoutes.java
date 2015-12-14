package com.akrome.utils.client.routes;

import com.akrome.utils.beans.orders.OrderBean;
import com.akrome.utils.beans.orders.OrderResponseBean;
import com.akrome.utils.client.Paths;
import com.google.inject.Inject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class OrderRoutes {
    @Inject
    Client client;

    public boolean postOrder(OrderBean orderBean) {
        WebTarget webtarget = client.target(Paths.getOrdersPath(orderBean.venue, orderBean.stock));
        Response response = webtarget.request().post(Entity.json(orderBean));
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            OrderResponseBean orderResponseBean = response.readEntity(OrderResponseBean.class);
            if (!orderResponseBean.ok) System.out.println(orderResponseBean.error);
            return orderResponseBean.ok;
        }
        else {
            return false;
        }
    }
}
