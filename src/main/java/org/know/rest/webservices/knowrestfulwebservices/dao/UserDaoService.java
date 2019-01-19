package org.know.rest.webservices.knowrestfulwebservices.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.know.rest.webservices.knowrestfulwebservices.model.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author KnowGroup
 */
@Component
public class UserDaoService {

    private static final List<User> users = new CopyOnWriteArrayList<>();
    private static final AtomicInteger counter = new AtomicInteger(3);
    static{
        users.add(new User(1,"Bharma",LocalDate.parse("1900-01-01")));
        users.add(new User(2,"Vishnu",LocalDate.parse("1900-01-01")));
        users.add(new User(3,"Mahesh",LocalDate.parse("1900-01-01")));
    }
    public List<User> allUsers() {
        return users;
    }

    protected UserDaoService() {
    }

    public User userWithId(Integer id) {
        return users.stream().filter(u -> u.getId() == id).findAny().get();
    }

    public User createUser(User user) {
        if(user.getId() == null){
            user.setId(counter.incrementAndGet());
        }
        users.add(user);
        return userWithId(counter.get());
    }
}
