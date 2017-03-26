package org.hbs.jpa.dao;

import org.hbs.jpa.model.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    protected SessionFactory factory;


    @Override
    public void listPersons() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Person").list();
            for (Iterator iterator =
                 employees.iterator(); iterator.hasNext(); ) {
                Person employee = (Person) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());

            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    @Override
    public void deletePerson(Long EmployeeID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person employee =
                    (Person) session.get(Person.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Long addPerson(Person person) {
        Session session = factory.openSession();
        Transaction tx = null;
        Long employeeID = null;
        try {
            tx = session.beginTransaction();


            employeeID = (Long) session.save(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }




}