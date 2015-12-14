package com.akrome.utils.beans.venues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public class VenueCollectionBean {
    public final boolean id;
    public final Collection<VenueBean> venues;

    @JsonCreator
    public VenueCollectionBean(
            @JsonProperty("id") boolean id,
            @JsonProperty("venues") Collection<VenueBean> venues) {
        this.id = id;
        this.venues = venues;
    }
}
