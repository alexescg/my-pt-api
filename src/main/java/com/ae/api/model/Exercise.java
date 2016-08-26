package com.ae.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by alex on 8/26/16.
 */
public class Exercise {

    private long id;

    @Length(max = 25)
    private String name;

    public Exercise() {
    }

    public Exercise(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }
}
