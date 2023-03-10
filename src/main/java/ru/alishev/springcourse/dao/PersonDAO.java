package ru.alishev.springcourse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        List<Person> people = session.createQuery("select p from Person p", Person.class)
                .getResultList();

        return people;
    }

    public Person show(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.load(Person.class, id);
    }

    public void save(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(person);
    }

    public void update(int id, Person updatedPerson) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(String.valueOf(id), updatedPerson);
    }

    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, id);
        if(null != p){
            session.delete(p);
        }
    }
}
