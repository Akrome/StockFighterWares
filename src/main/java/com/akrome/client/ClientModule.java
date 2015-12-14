package com.akrome.client;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class ClientModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Client.class).toProvider(ClientProvider.class).in(Scopes.SINGLETON);
    }
}
