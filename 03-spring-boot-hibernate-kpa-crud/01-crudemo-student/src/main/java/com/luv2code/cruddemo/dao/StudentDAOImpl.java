package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManger) {
        this.entityManager = entityManger;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findall() {
        // create query                       // Student is the name of JPA Entity class name
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);


        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        // JPW Name Parameters are prefixed with a colon
        TypedQuery<Student> theQuery = entityManager.createQuery(
                        "From Student Where lastName=:theData", Student.class);
        // set query parameters
        theQuery.setParameter("theData", theLastName);
        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }
}



