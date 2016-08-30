package com.ae.resource;

import com.ae.api.model.Exercise;
import com.ae.constants.ExerciseConstants;
import com.ae.db.ExerciseDAO;
import com.ae.resources.ExerciseResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by alex on 8/29/16.
 */
public class PersonResourceTest {

    private static final ExerciseDAO dao = mock(ExerciseDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ExerciseResource(dao))
            .build();

    private final Exercise exercise = new Exercise(ExerciseConstants.EXERCISE_NAME, ExerciseConstants.EXERCISE_DESCRIPTION);

    @Before
    public void setup() {
        dao.insert(ExerciseConstants.EXERCISE_NAME, ExerciseConstants.EXERCISE_DESCRIPTION);
        when(dao.findById(0)).thenReturn(exercise);
    }

    @After
    public void tearDown() {
        reset(dao);
    }

    @Test
    public void testGetExercise() {
        WebTarget target = resources.client().target("/exercise/0");
        Exercise requested = target.request().get(Exercise.class);

        System.out.println(requested);
        System.out.println(exercise);
        assertThat(requested).isEqualToComparingFieldByField(exercise);
        verify(dao).findById(0);
    }


}
