package it.albertus.spring.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = { "it.albertus.spring" },
	excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
	})
@EnableTransactionManagement // Abilita l'AOP per la gestione delle transazioni.
public class RootConfig {

	/** 
	 * Gestisce la transazionalita' dei metodi che accedono al database.
	 * In presenza di piu' transaction manager, bisogna specificare in
	 * @Transactional quale si vuole usare, pena "NoUniqueBeanDefinitionException".
	 */
	@Bean
	protected JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	/** Integrazione con Hibernate */
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("jpa_test");
		return emfb;
	}

}