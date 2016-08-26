package com.ae;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
        // TODO: application initialization
    }

    @Override
    public void run(final MyPTConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
