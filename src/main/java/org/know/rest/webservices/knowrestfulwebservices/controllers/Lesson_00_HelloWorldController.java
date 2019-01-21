package org.know.rest.webservices.knowrestfulwebservices.controllers;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KnowGroup
 */
@RestController
public class Lesson_00_HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World ! Let us know all.";
    }
    
    /**
     *
     * @return
     */
    @GetMapping(path = "/hello-world-bean")
    public HelloWorld helloWorldBean(){
        return new HelloWorld("Hello World ! Let us know all.");
    }

    @Autowired
    private MessageSource messageSource;
    
    @GetMapping(path = "/hello-world-international")
    public String helloWorldInternationlized(@RequestHeader(name = "Accept-Language",required = false) Locale locale){
        return messageSource.getMessage("hello-world-message",null,locale);
    }
    
    @GetMapping(path = "/hello-world-simple-international")
    public String helloWorldSimpleInternationlized(){
        return messageSource.getMessage("hello-world-message",null,LocaleContextHolder.getLocale());
    }
    
    /**
     *
     * @param name
     * @return
     */
    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorld helloWorldBeanPathVariable(@PathVariable String name){
        return new HelloWorld(String.format("Hello World ! %s let us know all.",name));
    }
    
    

}
class HelloWorld {

    private final String message;
        public HelloWorld(String message) {
        this.message = message;
        }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HelloWorld{" + "message=" + message + '}';
    }
        
        
    }



