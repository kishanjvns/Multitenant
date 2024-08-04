package com.tech.kj.config;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class MultinantConnectionProvider implements MultiTenantConnectionProvider, HibernatePropertiesCustomizer {
    private static final Logger log = LoggerFactory.getLogger(MultinantConnectionProvider.class);
    private final DataSource dataSource;
    public MultinantConnectionProvider(DataSource dataSource){
        this.dataSource = dataSource;
    }
    private static final String defaultSchemaName = "PUBLIC";
    @Override
    public Connection getAnyConnection() throws SQLException {
        return getConnection(defaultSchemaName);
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(Object o) throws SQLException {
        var connection = dataSource.getConnection();
        String tenantIdentifier = ((String)o);
        log.debug("tenantIdentifier: {}",tenantIdentifier);
        connection.setSchema(tenantIdentifier);
        return connection;
    }

    @Override
    public void releaseConnection(Object o, Connection connection) throws SQLException {
        connection.setSchema(defaultSchemaName);
        connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public  boolean isUnwrappableAs(Class<?> aClass) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER,this);
    }
}
