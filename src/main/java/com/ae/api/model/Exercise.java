package com.ae.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Entity representation of an Exercise.
 *
 * @author alexescg
 * @version 1.0
 * @since 8/26/16.
 */
public class Exercise {

    private long id;

    @Length(max = 25)
    private String name;

    @Length(max = 100)
    private String description;

    public Exercise() {
    }

    public Exercise(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
