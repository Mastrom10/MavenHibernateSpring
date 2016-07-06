package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.auto.Auto;
import ar.edu.uai.model.auto.AutoCriteria;

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
 * Created by Nicolas on 06/07/2016.
 */

public class AutoDAO implements PersistentDAO<Auto, Integer, AutoCriteria> {


    @PersistenceContext(unitName = "paradigms-persistence-unit")
    private EntityManager entityManager;

    @Override
    public Auto create(Auto auto) {
        this.entityManager.persist(auto);
        return auto;
    }

    @Override
    public Auto retrieve(Integer id) {
        return this.entityManager.find(Auto.class, id);
    }

    @Override
    public Auto update(Auto auto) {
        return this.entityManager.merge(auto);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(this.retrieve(id));
    }

    @Override
    public List<Auto> retrieveByCriteria(AutoCriteria autoCriteria) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Auto> query = cb.createQuery(Auto.class);
        Root<Auto> person = query.from(Auto.class);
        query.select(person);
        List<Predicate> predicates = new ArrayList<Predicate>();

        if(autoCriteria.getMarca() != null) {
            predicates.add(cb.and(cb.like(person.<String>get("marca"), "%" + autoCriteria.getMarca() + "%")));
        }

        if(autoCriteria.getMinModelo() != null) {
            predicates.add(cb.and(cb.ge(person.<Integer>get("modelo"), autoCriteria.getMinModelo())));
        }

        if(autoCriteria.getMaxModelo() != null) {
            predicates.add(cb.and(cb.le(person.<Integer>get("modelo"), autoCriteria.getMaxModelo())));
        }
        if(!predicates.isEmpty()) {
            query.where(predicates.toArray(new Predicate[predicates.size()]));
        }

        TypedQuery<Auto> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();
    }
}
