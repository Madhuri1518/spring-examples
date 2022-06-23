package com.zemoso.spring_examples.dao;


import com.zemoso.spring_examples.entity.Student;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public class StudentDAOImp implements StudentDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Student> getStudents() {
        // get the current hibernate session
        Session session = this.sessionFactory.openSession();
        // start a transaction
        session.beginTransaction();
        // create query
        Query query = session.createQuery("from Student", Student.class);
        List<Student> studentList = query.getResultList();
        // commit transaction
        session.getTransaction().commit();
        return studentList;
    }

    @Override
    public void saveStudent(Student student) {
        // get the current hibernate session
        Session session = this.sessionFactory.openSession();
        // start a transaction
        session.beginTransaction();
        // create query
        session.persist(student);
        // commit transaction
        session.getTransaction().commit();
    }

    @Override
    public Student getStudent(int id) {
        // get the current hibernate session
        Session session = this.sessionFactory.openSession();
        // start a transaction
        session.beginTransaction();
        // retrieve/read from database using the primary key
        Student student = session.get(Student.class, id);
        // commit transaction
        session.getTransaction().commit();
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        // get the current hibernate session
        Session session = this.sessionFactory.openSession();
        // start a transaction
        session.beginTransaction();
        // retrieve/read from database using the primary key
        Student student = session.get(Student.class, id);

        session.remove(student);
        // commit transaction
        session.getTransaction().commit();
    }
}
