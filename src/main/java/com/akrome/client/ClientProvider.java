package com.akrome.client;

import com.google.inject.Provider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class ClientProvider implements Provider<Client> {
    @Override
    public Client get() {
        return ClientBuilder.newClient();
    }
}
