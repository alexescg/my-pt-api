package com.ae.api.model;

import com.ae.constants.ExerciseConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import java.io.IOException;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alex on 8/29/16.
 */
public class ExerciseTest {

    private static final ObjectMapper mapper = Jackson.newObjectMapper();

    final Exercise exercise;
    final Exercise exerciseJson;

    public ExerciseTest() throws IOException {
        exercise = new Exercise(ExerciseConstants.EXERCISE_NAME, ExerciseConstants.EXERCISE_DESCRIPTION);
        exerciseJson = mapper.readValue(fixture(ExerciseConstants.EXERCISE_JSONLOCATION), Exercise.class);
    }

    @Test
    public void jsonSerialization() throws Exception {
        final String expected = mapper.writeValueAsString(exerciseJson);
        assertThat(mapper.writeValueAsString(exercise)).isEqualTo(expected);

    }

    @Test
    public void jsonDeserialization() throws Exception {
        assertThat(exerciseJson).isEqualToComparingFieldByField(exercise);
    }

}
