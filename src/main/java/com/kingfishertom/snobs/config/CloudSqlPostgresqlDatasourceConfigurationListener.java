package com.kingfishertom.snobs.config;

import com.google.cloud.sql.postgres.SocketFactory;

import io.micronaut.configuration.jdbc.hikari.DatasourceConfiguration;
import io.micronaut.context.event.BeanInitializedEventListener;
import io.micronaut.context.event.BeanInitializingEvent;
import jakarta.inject.Singleton;

@Singleton
class CloudSqlPostgresqlDatasourceConfigurationListener
		implements BeanInitializedEventListener<DatasourceConfiguration> {

	@Override
	public DatasourceConfiguration onInitialized(BeanInitializingEvent<DatasourceConfiguration> event) {

		DatasourceConfiguration config = event.getBean();

		config.setUrl("jdbc:postgresql:///");
		config.setDriverClassName(org.postgresql.Driver.class.getName());
		config.addDataSourceProperty("socketFactory", SocketFactory.class.getName());
		config.addDataSourceProperty("cloudSqlInstance", "kingfishertom-e7576:us-central1:snobs");

		/*
		 * maximumPoolSize limits the total number of concurrent connections this pool
		 * will keep. Ideal values for this setting are highly variable on app design,
		 * infrastructure, and database.
		 */
		config.setMaximumPoolSize(100);

		/*
		 * minimumIdle is the minimum number of idle connections Hikari maintains in the
		 * pool. Additional connections will be established to meet this value unless
		 * the pool is full.
		 */
		config.setMinimumIdle(1);

		/*
		 * setConnectionTimeout is the maximum number of milliseconds to wait for a
		 * connection checkout. Any attempt to retrieve a connection from this pool that
		 * exceeds the set limit will throw an SQLException.
		 */
		config.setConnectionTimeout(10000); // 10 seconds

		/*
		 * idleTimeout is the maximum amount of time a connection can sit in the pool.
		 * Connections that sit idle for this many milliseconds are retried if
		 * minimumIdle is exceeded.
		 */
		config.setIdleTimeout(600000); // 10 minutes

		/*
		 * maxLifetime is the maximum possible lifetime of a connection in the pool.
		 * Connections that live longer than this many milliseconds will be closed and
		 * reestablished between uses. This value should be several minutes shorter than
		 * the database's timeout value to avoid unexpected terminations.
		 */
		config.setMaxLifetime(1800000); // 30 minutes

		return config;
	}
}