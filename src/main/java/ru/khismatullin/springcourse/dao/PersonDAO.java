package ru.khismatullin.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.khismatullin.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Michael", 16, "michael@mail.us"));
        people.add(new Person(++PEOPLE_COUNT, "Lillian", 17, "lillian@mail.us"));
        people.add(new Person(++PEOPLE_COUNT, "Nicholas", 18, "nicholas@mail.us"));
        people.add(new Person(++PEOPLE_COUNT, "Evelyn", 19, "evelyn@mail.us"));

        /*people.add(new Person(++PEOPLE_COUNT, "Robert"));
        people.add(new Person(++PEOPLE_COUNT, "Ivy"));
        people.add(new Person(++PEOPLE_COUNT, "Miles"));
        people.add(new Person(++PEOPLE_COUNT, "Annie"));
        people.add(new Person(++PEOPLE_COUNT, "James"));
        people.add(new Person(++PEOPLE_COUNT, "Hope"));
        people.add(new Person(++PEOPLE_COUNT, "Graham"));
        people.add(new Person(++PEOPLE_COUNT, "Rosie"));
        people.add(new Person(++PEOPLE_COUNT, "Emmet"));
        people.add(new Person(++PEOPLE_COUNT, "Tess"));
        people.add(new Person(++PEOPLE_COUNT, "William"));
        people.add(new Person(++PEOPLE_COUNT, "Maggie"));
        people.add(new Person(++PEOPLE_COUNT, "Ralph"));
        people.add(new Person(++PEOPLE_COUNT, "Dorothy"));
        people.add(new Person(++PEOPLE_COUNT, "Fletcher"));
        people.add(new Person(++PEOPLE_COUNT, "Jenna"));
        people.add(new Person(++PEOPLE_COUNT, "Julian"));
        people.add(new Person(++PEOPLE_COUNT, "Kate"));*/
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(e->e.getId()==id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete (int id) {
        people.removeIf(e->e.getId() == id);
    }
}
