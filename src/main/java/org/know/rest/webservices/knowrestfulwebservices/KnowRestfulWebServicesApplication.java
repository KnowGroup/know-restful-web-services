package org.know.rest.webservices.knowrestfulwebservices;

import java.util.Locale;
import java.util.ResourceBundle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class KnowRestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowRestfulWebServicesApplication.class, args);
	}
        
        @Bean
        public LocaleResolver localeResolver(){
            final SessionLocaleResolver localeResolver = new SessionLocaleResolver(); 
            localeResolver.setDefaultLocale(Locale.US);
            return localeResolver;
        }
        
        @Bean
        public ResourceBundleMessageSource messageSource(){
            final ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
                rbms.setBasename("messages");
            return rbms;
        }

}

