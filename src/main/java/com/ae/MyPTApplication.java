package com.ae;

import com.ae.db.ExerciseDAO;
import com.ae.db.MigrationBundle;
import com.ae.resources.ExerciseResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.DBIHealthCheck;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class MyPTApplication extends Application<MyPTConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MyPTApplication().run(args);
    }

    @Override
    public String getName() {
        return "My Personal Trainer API";
    }

    @Override
    public void initialize(final Bootstrap<MyPTConfiguration> bootstrap) {
        bootstrap.addBundle(new DBIExceptionsBundle());
        bootstrap.addBundle(new MigrationBundle());


    }

    @Override
    public void run(final MyPTConfiguration configuration,
                    final Environment environment) {
        final DBIFactory factory = new DBIFactory();
        final DBI database = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

        //DAOs
        final ExerciseDAO dao = database.onDemand(ExerciseDAO.class);
        environment.jersey().register(new ExerciseResource(dao));

        //HealthChecks
        environment.healthChecks().register("database", new DBIHealthCheck(database, "/* Database Health Check */ SELECT 1"));
    }

}
