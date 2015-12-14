package com.akrome.utils.client;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

import javax.ws.rs.client.Client;

public class ClientModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Client.class).toProvider(ClientProvider.class).in(Scopes.SINGLETON);
    }
}
