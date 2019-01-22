package org.know.rest.webservices.knowrestfulwebservices.dao;

import org.know.rest.webservices.knowrestfulwebservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author KnowGroup
 */
public interface UserRepositor extends JpaRepository<User, Integer>{

}
