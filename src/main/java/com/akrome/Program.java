package com.akrome;

import com.akrome.client.routes.Healthcheck;
import com.google.inject.Guice;
import com.google.inject.Inject;

public class Program {
    @Inject
    Healthcheck healthcheck;

    public static void main(String[] args) {
        Program p = Guice.createInjector(new MainModule()).getInstance(Program.class);
        p.run(args);
    }

    public void run(String[] args) {
        System.out.println(healthcheck.isApiUp());
    }
}
