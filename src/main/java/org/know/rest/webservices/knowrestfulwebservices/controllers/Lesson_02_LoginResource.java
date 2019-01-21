package org.know.rest.webservices.knowrestfulwebservices.controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.know.rest.webservices.knowrestfulwebservices.model.Login;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KnowGroup
 */
@RestController
public class Lesson_02_LoginResource {

    @GetMapping("/login")
    public MappingJacksonValue fetchLogin(){
        final Login login = new Login(3,"password");
        final MappingJacksonValue mapping = new MappingJacksonValue(login);
        final FilterProvider fp = new SimpleFilterProvider().addFilter("dynamicFieldFilter", 
                        SimpleBeanPropertyFilter.filterOutAllExcept("userId"));
        mapping.setFilters(fp);
        return mapping;
    }
}
