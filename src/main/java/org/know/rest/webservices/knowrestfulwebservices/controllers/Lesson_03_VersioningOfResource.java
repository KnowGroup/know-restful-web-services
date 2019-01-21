package org.know.rest.webservices.knowrestfulwebservices.controllers;

import org.know.rest.webservices.knowrestfulwebservices.model.Name;
import org.know.rest.webservices.knowrestfulwebservices.model.PersonV1;
import org.know.rest.webservices.knowrestfulwebservices.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KnowGroup
 */
@RestController
public class Lesson_03_VersioningOfResource {

    /*
        Path versioning
    */
    
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Funny Bunny");
    }
    
    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Funny","","Bunny"));
    }
    
    
    /*
        Param versioning
    */
    
    @GetMapping(value ="/person" , params = "version=1")
    public PersonV1 paramPersonV1(){
        return new PersonV1("Funny Bunny");
    }
    
    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 paramPersonV2(){
        return new PersonV2(new Name("Funny","","Bunny"));
    }
    
    /*
        Header versioning
    */
    
    @GetMapping(value ="/person/header" , headers = "X-API-VERSION=1")
    public PersonV1 headerPersonV1(){
        return new PersonV1("Funny Bunny");
    }
    
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerPersonV2(){
        return new PersonV2(new Name("Funny","","Bunny"));
    }

    /*
        AcceptHeader / Media typer versioning
    */
    
    @GetMapping(value ="/person/produce" , produces = "application/know.group.webservices.app-v1+json")
    public PersonV1 producePersonV1(){
        return new PersonV1("Funny Bunny");
    }
    
    @GetMapping(value = "/person/produce", produces = "application/know.group.webservices.app-v2+json")
    public PersonV2 producePersonV2(){
        return new PersonV2(new Name("Funny","","Bunny"));
    }
    
    
}
