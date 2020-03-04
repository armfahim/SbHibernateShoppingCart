package org.o7planning.sbshoppingcart;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication

@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})
@Slf4j
public class SbHibernateShoppingCartApplication {
	
	@Autowired
	Environment env;
	
	@Value("${spring.datasource.driver-class-name}")
	private String dbDriver;
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	@Value("${spring.datasource.username}")
	private String dbUser;
	
	@Value("${spring.datasource.password}")
	private String dbPass;

	public static void main(String[] args) {
		SpringApplication.run(SbHibernateShoppingCartApplication.class, args);
	}
	
	/**
	 * configure Database connection
	 * @return DataSource object
	 */
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		//see: application.properties
		dataSource.setDriverClassName(dbDriver);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUser);
		dataSource.setPassword(dbPass);
		
		log.info("getDataSource"+dataSource);
		
		return dataSource;
		
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		Properties properties = new Properties();
		
        //see: application.properties
		properties.put("hibernate.dialect", );
		return null;
		
	}

}
