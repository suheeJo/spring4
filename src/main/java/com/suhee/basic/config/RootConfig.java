package com.suhee.basic.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@PropertySource({"classpath:commons.properties"})
public class RootConfig {
	
	@Autowired
    private Environment env;
	
	@Bean(destroyMethod="close")
	public DataSource dataSource()  {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("mysql.driverClassName"));
		dataSource.setUrl(env.getProperty("mysql.url"));
		dataSource.setUsername(env.getProperty("mysql.username"));
		dataSource.setPassword(env.getProperty("mysql.password"));
		dataSource.setInitialSize(Integer.parseInt(env.getProperty("mysql.initialSize")));
		dataSource.setMaxIdle(Integer.parseInt(env.getProperty("mysql.maxIdle")));
//		dataSource.setMaxActive(Integer.parseInt(env.getProperty("mysql.maxActive")));
		dataSource.setValidationQuery(env.getProperty("mysql.validationQuery"));
		dataSource.setTestWhileIdle(Boolean.parseBoolean(env.getProperty("mysql.testWhileIdle")));
		dataSource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(env.getProperty("mysql.timeBetweenEvictionRunsMillis")));
    	return dataSource;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:**/dao/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	/*
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(env.getProperty(".redis.host"));
        jedisConnectionFactory.setPort(Integer.parseInt(env.getProperty(".redis.port")));
        jedisConnectionFactory.setPassword(env.getProperty(".redis.password"));
        jedisConnectionFactory.setDatabase(Integer.parseInt(env.getProperty(".redis.db")));
        jedisConnectionFactory.setUsePool(Boolean.parseBoolean(env.getProperty(".redis.pool")));
		return jedisConnectionFactory;
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplete() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	*/
}
