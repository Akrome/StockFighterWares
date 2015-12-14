package com.akrome.utils.beans.venues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VenueHealthcheckBean {
    public final boolean ok;
    public final String venue;

    @JsonCreator
    public VenueHealthcheckBean(
            @JsonProperty("ok") boolean ok,
            @JsonProperty("venue") String venue) {
        this.ok = ok;
        this.venue = venue;
    }
}
