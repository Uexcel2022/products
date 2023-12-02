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
        datasource.setPassword("jvman16");
        datasource.setDataSourceClassName("org.mariadb.jdbc.Driver");
        return datasource;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNonJtaDataSource'");
    }

    @Override
    public List<String> getMappingFileNames() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMappingFileNames'");
    }

    @Override
    public List<URL> getJarFileUrls() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getJarFileUrls'");
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersistenceUnitRootUrl'");
    }

    @Override
    public List<String> getManagedClassNames() {
        return List.of("com.uexcel.entity.Product");
    }

    @Override
    public boolean excludeUnlistedClasses() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excludeUnlistedClasses'");
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSharedCacheMode'");
    }

    @Override
    public ValidationMode getValidationMode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValidationMode'");
    }

    @Override
    public Properties getProperties() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProperties'");
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersistenceXMLSchemaVersion'");
    }

    @Override
    public ClassLoader getClassLoader() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClassLoader'");
    }

    @Override
    public void addTransformer(ClassTransformer transformer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTransformer'");
    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNewTempClassLoader'");
    }

}
