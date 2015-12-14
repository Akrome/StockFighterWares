package com.akrome;

import com.akrome.utils.client.ClientModule;
import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new ClientModule());
    }
}