package com.ae.api.model;

import java.util.List;

/**
 * Created by alex on 8/26/16.
 */
public class Workout {

    private Long id;

    private List<Set> exercises;

    public Workout() {

    }

    public Workout(Long id, List<Set> exercises) {
        this.id = id;
        this.exercises = exercises;
    }

    public Long getId() {
        return id;
    }

    public List<Set> getExercises() {
        return exercises;
    }
}
