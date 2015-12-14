package com.akrome.utils.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HeartbeatBean {
    public final boolean ok;
    public final String error;

    @JsonCreator
    public HeartbeatBean(
            @JsonProperty("ok") boolean ok,
            @JsonProperty("error") String error) {
        this.ok = ok;
        this.error = error;
    }
}
