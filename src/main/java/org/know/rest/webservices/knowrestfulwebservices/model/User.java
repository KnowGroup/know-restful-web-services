package org.know.rest.webservices.knowrestfulwebservices.model;

import java.time.LocalDate;

/**
 *
 * @author KnowGroup
 */
public class User {

    private Integer id;

    private String name;

    private LocalDate date;

    protected User(){
        
    }
    public User(int id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", date=" + date + '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}