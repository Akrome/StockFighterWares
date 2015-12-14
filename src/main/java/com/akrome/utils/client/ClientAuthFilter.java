package com.akrome.utils.client;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;

public class ClientAuthFilter implements ClientRequestFilter {
    static final String AUTH_HEADER = " X-Starfighter-Authorization";

    @Inject
    @Named(ApiKeyProvider.API_KEY_NAME)
    String apiKeyValue;

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        if (clientRequestContext.getHeaders().get(AUTH_HEADER) == null) {
            clientRequestContext.getHeaders().add(AUTH_HEADER, apiKeyValue);
        }
    }
}
