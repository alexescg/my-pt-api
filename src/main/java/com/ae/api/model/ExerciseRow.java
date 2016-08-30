package com.ae.api.model;

/**
 * Entity representation of an ExerciseRow.
 *
 * @author alexescg
 * @version 1.0
 * @since 8/26/16.
 */
public class ExerciseRow {

    private Long id;

    private Integer reps;

    private Integer sets;

    private Integer repMin;

    private Integer repMax;

    public ExerciseRow() {
    }

    public ExerciseRow(Long id, Integer reps, Integer sets, Integer repMin, Integer repMax) {
        this.id = id;
        this.reps = reps;
        this.sets = sets;
        this.repMin = repMin;
        this.repMax = repMax;
    }

    public Long getId() {
        return id;
    }

    public Integer getReps() {
        return reps;
    }

    public Integer getSets() {
        return sets;
    }

    public Integer getRepMin() {
        return repMin;
    }

    public Integer getRepMax() {
        return repMax;
    }
}
