package org.know.rest.webservices.knowrestfulwebservices.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.know.rest.webservices.knowrestfulwebservices.dao.UserRepositor;
import org.know.rest.webservices.knowrestfulwebservices.exception.UserNotFoundException;
import org.know.rest.webservices.knowrestfulwebservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author KnowGroup
 */
@RestController
public class Lesson_04_OperationsOnJpaResource {

    @Autowired
    private UserRepositor userRepo;
    
    @GetMapping(path = "/jpa/users")
    public List<User> retriveAllUsers(){
        return userRepo.findAll();
    }
    
    @GetMapping(path = "/jpa/users/id/{id}")
    public Resource<User> retriveUser(@PathVariable Integer id){
        final Optional<User> user = userRepo.findById(id);
        if(!user.isPresent()) throw new UserNotFoundException("id : "+id);
        
        final Resource<User> resource = new Resource<>(user.get());
        final ControllerLinkBuilder controllerLinkBuilder = linkTo(methodOn(this.getClass()).retriveAllUsers());
            resource.add(controllerLinkBuilder.withRel("all-Users"));
        return resource;
    }
    
    @DeleteMapping(path = "/jpa/users/id/{id}")
    public void deleteUser(@PathVariable Integer id){
        userRepo.deleteById(id);        
    }
    
    @PostMapping(path = "/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        final User savedUser = userRepo.save(user);
        final URI resourceLocation = 
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/id/{id}")
                    .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(resourceLocation).build();
    }
    
}
