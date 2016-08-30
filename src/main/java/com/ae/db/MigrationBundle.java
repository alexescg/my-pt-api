package com.ae.db;

import com.ae.MyPTConfiguration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;

/**
 * Bundle used for Migrations
 *
 * @author alexescg
 * @version 1.0
 * @since 8/29/16.
 */
public class MigrationBundle extends MigrationsBundle<MyPTConfiguration> {

    @Override
    public DataSourceFactory getDataSourceFactory(MyPTConfiguration configuration) {
        return configuration.getDataSourceFactory();
    }
}
