package org.know.rest.webservices.knowrestfulwebservices.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author KnowGroup
 */
@ApiModel(description = "User Details")
public class User {

    private Integer id;

    @Size(min = 2, message = "User Name must be of minimum 2 letters")
    @ApiModelProperty(notes="Name must be of minimum 2 letters")
    @NotNull
    private String name;

    @Past( message = "Birthdate must only be in past")
    @ApiModelProperty(notes="Birthdate must be in past")
    @NotNull
    private LocalDate birthDate;

    protected User(){
        
    }
    public User(int id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.birthDate = date;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", Birthdate=" + birthDate + '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.birthDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        return true;
    }
    
}