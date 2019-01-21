package org.know.rest.webservices.knowrestfulwebservices;

import java.util.Arrays;
import java.util.HashSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author KnowGroup
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private final Contact DEFAULT_CONTACT = new Contact("Know Group","https://github.com/KnowGroup","info.knowgroup@gmail.com");
    private final ApiInfo DEFAULT_API_INFO = new ApiInfo("Know RESTful Web Services", 
                        "Know how to create RESTful webservices using Spring boot, Swagger, JPA", 
                        "1.0-BETA", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0");

    @Bean
    public Docket api(){
        DEFAULT_PRODUCE_CONSUME = new HashSet<>(Arrays.asList("application/json","application/xml"));
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .consumes(DEFAULT_PRODUCE_CONSUME)
                .produces(DEFAULT_PRODUCE_CONSUME);
    }
    private HashSet<String> DEFAULT_PRODUCE_CONSUME;
}
