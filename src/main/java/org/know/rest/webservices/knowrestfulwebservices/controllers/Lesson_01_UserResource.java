package org.know.rest.webservices.knowrestfulwebservices.controllers;

import java.net.URI;
import java.util.List;
import org.know.rest.webservices.knowrestfulwebservices.dao.UserDaoService;
import org.know.rest.webservices.knowrestfulwebservices.exception.UserNotFoundException;
import org.know.rest.webservices.knowrestfulwebservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Lesson_01_UserResource {

    @Autowired
    private UserDaoService daoService;
    
    @GetMapping(path = "/users")
    public List<User> retriveAllUsers(){
        return daoService.allUsers();
    }
    
    @GetMapping(path = "/users/id/{id}")
    public User retriveUser(@PathVariable Integer id){
        final User user = daoService.userWithId(id);
        if(user == null) throw new UserNotFoundException("id : "+id); 
        return user;
    }
    
    @DeleteMapping(path = "/users/id/{id}")
    public void deleteUser(@PathVariable Integer id){
        final User user = daoService.deleteUserWithId(id);
        if(user == null) throw new UserNotFoundException("id : "+id); 
    }
    
    @PostMapping(path = "users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        final User savedUser = daoService.createUser(user);
        final URI resourceLocation = 
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/id/{id}")
                    .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(resourceLocation).build();
    }
    
}
