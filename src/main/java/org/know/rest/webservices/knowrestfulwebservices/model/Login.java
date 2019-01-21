package org.know.rest.webservices.knowrestfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author KnowGroup
 */
@JsonFilter("dynamicFieldFilter")
public class Login {

    private final Integer userId;
    @JsonIgnore
    private final String password;

    protected Login() {
        this.userId = null;
        this.password = null;
    }

    
    public Login(Integer userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
