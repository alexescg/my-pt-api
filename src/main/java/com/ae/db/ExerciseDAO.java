package com.ae.db;

import com.ae.api.model.Exercise;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.List;
import java.util.Optional;

/**
 * Created by alex on 8/29/16.
 */
public interface ExerciseDAO {

    @SqlUpdate("create table exercise (id int primary key, name varchar(25), description(100))")
    void createExerciseTable();

    @SqlUpdate("insert into exercise (name, description) values (:name, :description)")
    void insert(@Bind("name") String name, @Bind("description") String description);

    @SqlQuery("select * from exercise where id = :id")
    Exercise findById(@Bind("id") int id);

    @SqlQuery("select * from exercise")
    List<Exercise> all();

}
