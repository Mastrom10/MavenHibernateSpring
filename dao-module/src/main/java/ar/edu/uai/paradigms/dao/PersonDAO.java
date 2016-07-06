package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.person.Person;
import ar.edu.uai.model.person.PersonCriteria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Federico on 19/10/2014.
 */
public class PersonDAO implements PersistentDAO<Person, Integer, PersonCriteria> {

    @PersistenceContext(unitName = "paradigms-persistence-unit")
    private EntityManager entityManager;

    @Override
    public Person create(Person person) {
        this.entityManager.persist(person);
        return person;
    }

    @Override
    public Person retrieve(Integer id) {
        return this.entityManager.find(Person.class, id);
    }

    @Override
    public Person update(Person person) {
        return this.entityManager.merge(person);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(this.retrieve(id));
    }

    @Override
    public List<Person> retrieveByCriteria(PersonCriteria personCriteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = cb.createQuery(Person.class);
        Root<Person> person = query.from(Person.class);
        query.select(person);
        List<Predicate> predicates = new ArrayList<Predicate>();

        if(personCriteria.getName() != null) {
            predicates.add(cb.and(cb.like(person.<String>get("name"), "%" + personCriteria.getName() + "%")));
        }

        if(personCriteria.getMinAge() != null) {
            predicates.add(cb.and(cb.ge(person.<Integer>get("age"), personCriteria.getMinAge())));
        }

        if(personCriteria.getMaxAge() != null) {
            predicates.add(cb.and(cb.le(person.<Integer>get("age"), personCriteria.getMaxAge())));
        }
        if(!predicates.isEmpty()) {
            query.where(predicates.toArray(new Predicate[predicates.size()]));
        }

        TypedQuery<Person> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();
    }
}
