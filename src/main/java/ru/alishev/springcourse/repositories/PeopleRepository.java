package ru.alishev.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alishev.springcourse.models.Person;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    public List<Person> findByName(String name);

    public List<Person> findByNameOrderByAge(String name);

    public List<Person> findByEmail(String email);

    public List<Person> findByNameStartingWith(String startingWith);

    public List<Person> findByNameOrEmail(String name, String email);
}
