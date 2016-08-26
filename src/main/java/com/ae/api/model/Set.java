package com.ae.api.model;

/**
 * Created by alex on 8/26/16.
 */
public class Set {

    private Long id;

    private Integer reps;

    private Integer sets;

    private Integer repMin;

    private Integer repMax;

    public Set() {
    }

    public Set(Long id, Integer reps, Integer sets, Integer repMin, Integer repMax) {
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
