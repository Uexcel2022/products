package com.uexcel.persistence;

import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

public class CustomPersistenceUnitInfo implements PersistenceUnitInfo {

    @Override
    public String getPersistenceUnitName() {
        return "my-persistence-unit";
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {

        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public DataSource getJtaDataSource() {
        HikariDataSource datasource = new HikariDataSource();
        datasource.setJdbcUrl("jdbc:mariadb://localhost:3306/hibernate_demo");
        datasource.setUsername("root");
        datasource.setPassword("jvman19");
        datasource.setDriverClassName("org.mariadb.jdbc.Driver");
        return datasource;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return null;
    }

    @Override
    public List<URL> getJarFileUrls() {
        return null;

    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        return List.of("com.uexcel.entity.Product");
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        Properties p = new Properties();
        // p.setProperty("jakarta.persistence.jdbc.driver", "org.mariadb.jdbc.Driver");
        // p.setProperty(
        // "jakarta.persistence.jdbc.url",
        // "jdbc:mariadb://localhost:3306/hibernate_demo");
        // p.setProperty("jakarta.persistence.jdbc.user", "root");
        // p.setProperty("jakarta.persistence.jdbc.password", "jvman19");

        p.setProperty("hibernate.show_sql", "true");
        p.setProperty("hibernate.format_sql", "true");
        return p;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer transformer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTransformer'");
    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }

}
