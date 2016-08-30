package com.ae.resources;

import com.ae.api.model.Exercise;
import com.ae.db.ExerciseDAO;
import com.ae.error.ResponseError;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

/**
 * Created by alex on 8/29/16.
 */
@Path("/exercise")
@Produces(MediaType.APPLICATION_JSON)
public class ExerciseResource {

    @Valid
    @NotNull
    final ExerciseDAO exerciseDAO;

    public ExerciseResource(ExerciseDAO exerciseDAO) {
        this.exerciseDAO = exerciseDAO;
    }

    @GET
    public Response all() {
        List<Exercise> exercises = exerciseDAO.all();
        if (exercises.isEmpty()) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.OK).entity(exercises).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response show(@PathParam("id") Integer id) {
        Optional<Exercise> exercise = exerciseDAO.findById(id);
        if (exercise.isPresent()) {
            return Response.status(Response.Status.OK).entity(exercise).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }


}
