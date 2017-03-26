package org.hbs.jpa.dao;

import org.hbs.jpa.model.Person;

/**
 * Created by Hardik on 24-03-2017.
 */
public interface PersonDao {

    void listPersons();

    void deletePerson(Long EmployeeID);

    Long addPerson(Person person);
}
