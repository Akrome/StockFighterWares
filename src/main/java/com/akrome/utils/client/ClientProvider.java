package com.akrome.utils.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.inject.Provider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.ext.ContextResolver;

public class ClientProvider implements Provider<Client> {
    @Override
    public Client get() {
        return ClientBuilder
                .newBuilder()
                .register(new ObjectMapperResolver())
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(new ApiKeyProvider().provide()).to(String.class).named(ApiKeyProvider.API_KEY_NAME);
                    }
                })
                .register(ClientAuthFilter.class)
                .build();
    }


    private class ObjectMapperResolver implements ContextResolver<ObjectMapper> {
        private final ObjectMapper mapper;
        public ObjectMapperResolver() {
            mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        }
        
        @Override
        public ObjectMapper getContext(Class<?> aClass) {
            return mapper;
        }
    }
}
