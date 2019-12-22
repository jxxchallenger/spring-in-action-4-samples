package io.jxxchallenger.springinaction.profiles;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

    @Bean(destroyMethod = "shutdown")
    @Profile(value = {"dev"})
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addDefaultScripts().build();
    }
    
    @Bean(destroyMethod = "close")
    @Profile(value = {"test", "QA"})
    public DataSource poolDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springinaction");
        dataSource.setUsername("cwx566533");
        dataSource.setPassword("123456");
        return dataSource;
    }
    
    @Bean(destroyMethod = "close")
    @Profile(value = {"performance"})
    public DataSource performanceDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/springinaction");
        config.setUsername("cwx566533");
        config.setPassword("123456");
        config.addDataSourceProperty("autoCommit", true);
        config.addDataSourceProperty("connectionTimeout", 30000);
        config.addDataSourceProperty("idleTimeout", 600000);
        config.addDataSourceProperty("maxLifetime", 1800000);
        config.addDataSourceProperty("allowMultiQueries", true);
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("allowMultiQueries", true);
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        config.addDataSourceProperty("useServerPrepStmts", true);
        config.addDataSourceProperty("useLocalSessionState", true);
        config.addDataSourceProperty("rewriteBatchedStatements", true);
        config.addDataSourceProperty("cacheResultSetMetadata", true);
        config.addDataSourceProperty("cacheServerConfiguration", true);
        return new HikariDataSource(config);
    }
    
    @Bean
    @Profile(value = {"prod"})
    public DataSource jndiDataSource() {
        JndiObjectFactoryBean factoryBean = new JndiObjectFactoryBean();
        factoryBean.setJndiName("jdbc/myDS");
        factoryBean.setResourceRef(true);
        factoryBean.setProxyInterface(DataSource.class);
        return (DataSource) factoryBean.getObject();
    }
}
