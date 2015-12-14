package com.akrome.utils.beans.venues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VenueBean {
    public final int id;
    public final String name;
    public final String state;
    public final String venue;

    @JsonCreator
    public VenueBean(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("state") String state,
            @JsonProperty("venue") String venue) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.venue = venue;
    }
}
