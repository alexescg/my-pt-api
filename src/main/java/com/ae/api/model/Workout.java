package com.ae.api.model;

import java.util.List;


/**
 * Entity representation of a Workout.
 *
 * @author alexescg
 * @version 1.0
 * @since 8/26/16.
 */
public class Workout {

    private Long id;

    private List<ExerciseRow> exercises;

    public Workout() {

    }

    public Workout(Long id, List<ExerciseRow> exercises) {
        this.id = id;
        this.exercises = exercises;
    }

    public Long getId() {
        return id;
    }

    public List<ExerciseRow> getExercises() {
        return exercises;
    }
}
