package org.o7planning.sbshoppingcart;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
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
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication

@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})
@Slf4j
public class SbHibernateShoppingCartApplication {
	
//	Environment env = new Envi;
	
	 private static StandardServiceRegistry registry;
	 private static SessionFactory sessionFactory;
	
//	@Value("${spring.datasource.driver-class-name}")
//	private String dbDriver;
//	
//	@Value("${spring.datasource.url}")
//	private String dbUrl;
//	
//	@Value("${spring.datasource.username}")
//	private String dbUser;
//	
//	@Value("${spring.datasource.password}")
//	private String dbPass;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SbHibernateShoppingCartApplication.class, args);
		
		Configuration cfg = new  Configuration();
		Properties p = new Properties();
		//load properties file
		p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
		cfg.setProperties(p);
		cfg.addAnnotatedClass(Products.class);
		// build session factory
		SessionFactory factory = cfg.buildSessionFactory();
		// get session
		Session session = factory.openSession();
		System.out.println(session.isConnected());
		Products products = new Products(11,"rangpur","fahim@gmail.com","Fahim","01767564010");
		session.save(products);  
//	    t.commit();  
//	    System.out.println("successfully saved");    
//	    factory.close();  
//	    session.close();
		// close session
		session.close();
		System.out.println(session.isConnected());
		
		
		
//		  StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//          
//		   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
//		  
//		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
//		Session session = factory.openSession();  
//		Transaction t = session.beginTransaction();   
//		
//		Products products = new Products(11,"dhaka","fahim@gmail.com","Fahim","01767564010");
//		products.setAddress("dhaka");
//		products.setEmail("fahim@gmail.com");
//		products.setName("Fahim");
//		products.setPhone("01767564010");
//		
//		session.save(products);  
//	    t.commit();  
//	    System.out.println("successfully saved");    
//	    factory.close();  
//	    session.close();
		
//-------------------------------
		
//        Transaction transaction = null;
        
//        try (Session session = getSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            // save the student objects
//            session.save(products);
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
        
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            List < Student > students = session.createQuery("from Student", Student.class).list();
//            students.forEach(s - > System.out.println(s.getFirstName()));
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
    }
	
	/**
	 * configure Database connection
	 * @return DataSource object
	 */
//	@Bean(name = "dataSource")
//	public DataSource getDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		
//		//see: application.properties
//		dataSource.setDriverClassName(dbDriver);
//		dataSource.setUrl(dbUrl);
//		dataSource.setUsername(dbUser);
//		dataSource.setPassword(dbPass);
//		
//		System.out.println("getDataSource: "+dataSource);
//		log.info("getDataSource: "+dataSource);
//		
//		return dataSource;
//		
//	}
//	@Bean(name = "sessionFactory")
//	public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            try {
//                // Create registry
//                registry = new StandardServiceRegistryBuilder().configure().build();
//                // Create MetadataSources
//                MetadataSources sources = new MetadataSources(registry);
//                // Create Metadata
//                Metadata metadata = sources.getMetadataBuilder().build();
//                // Create SessionFactory
//                sessionFactory = metadata.getSessionFactoryBuilder().build();
//            } catch (Exception e) {
//                e.printStackTrace();
//                if (registry != null) {
//                    StandardServiceRegistryBuilder.destroy(registry);
//                }
//            }
//        }
//        return sessionFactory;
//    }
	
//	@Bean(name = "shutdown")
//	public static void shutdown() {
//	        if (registry != null) {
//	            StandardServiceRegistryBuilder.destroy(registry);
//	        }
//	    }

	
}
