package com.akrome.utils.client;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import com.google.inject.servlet.ServletModule;

import javax.ws.rs.client.Client;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ClientModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Client.class).toProvider(ClientProvider.class).in(Scopes.SINGLETON);
    }
}
