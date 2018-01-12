package com.boot.operations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableCaching
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringBootMainApplication {
	
	public static void main(String[] args) {
		

		SpringApplication.run(SpringBootMainApplication.class, args);
	}
	
	/****
	 * We don't need this cache manager
	 * add
	 * spring.cache.cache-names=employeeCache
		spring.cache.type=ehcache
		spring.cache.ehcache.config=classpath:ehcache.xml
		in application.properties
	 */
	/* @Bean
	    public CacheManager cacheManager() {
	        return new EhCacheCacheManager(cacheMangerFactory().getObject());
	    }

	    @Bean
	    public EhCacheManagerFactoryBean cacheMangerFactory() {	
	        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
	        bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
	        bean.setShared(true);
	        return bean;
	    }*/
}
