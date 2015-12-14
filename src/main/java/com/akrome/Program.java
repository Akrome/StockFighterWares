package com.akrome;

import com.akrome.utils.client.routes.HeartbeatRoutes;
import com.akrome.utils.client.routes.VenueRoutes;
import com.google.inject.Guice;
import com.google.inject.Inject;

public class Program {
    @Inject
    HeartbeatRoutes healthcheckRoute;

    @Inject
    VenueRoutes venueRoute;

    public static void main(String[] args) {
        Program p = Guice.createInjector(new MainModule()).getInstance(Program.class);
        p.run(args);
    }

    public void run(String[] args) {
        System.out.println("System: "+ healthcheckRoute.isApiUp());


        String venue;
        venue = args[0];
        System.out.println("Venue "+venue+": "+ venueRoute.isVenueUp(venue));

    }
}
