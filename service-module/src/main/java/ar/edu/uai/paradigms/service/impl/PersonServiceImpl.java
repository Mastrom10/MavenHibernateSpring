package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.person.Person;
import ar.edu.uai.model.person.PersonCriteria;
import ar.edu.uai.paradigms.dao.PersonDAO;
import ar.edu.uai.paradigms.service.PersonService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private PersonDAO personDAO;

    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Transactional
    public Person savePerson(Person person) {
        return this.personDAO.create(person);
    }

    @Override
    public Person retrievePerson(Integer identifier) {
        return this.personDAO.retrieve(identifier);
    }

    @Transactional
    @Override
    public void deletePerson(Integer identifier) {
        this.personDAO.delete(identifier);
    }

    @Override
    public List<Person> retrieveByCriteria(PersonCriteria criteria) {
        return this.personDAO.retrieveByCriteria(criteria);
    }

}
