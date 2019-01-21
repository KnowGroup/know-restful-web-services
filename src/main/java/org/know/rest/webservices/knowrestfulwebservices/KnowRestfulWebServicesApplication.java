package org.know.rest.webservices.knowrestfulwebservices;

import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class KnowRestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowRestfulWebServicesApplication.class, args);
	}
        
        @Bean
        public LocaleResolver localeResolver(){
//            final SessionLocaleResolver localeResolver = new SessionLocaleResolver(); 
            final AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
                localeResolver.setDefaultLocale(Locale.US);
            return localeResolver;
        }
        
        
        /*
        NO need to add this code just add mapping in application.properties

        @Bean
        public ResourceBundleMessageSource messageSource(){
            final ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
                rbms.setBasename("messages");
            return rbms;
        }
    */

}

