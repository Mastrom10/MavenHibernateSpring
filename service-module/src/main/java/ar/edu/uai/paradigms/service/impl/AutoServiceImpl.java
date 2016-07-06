package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.auto.Auto;
import ar.edu.uai.model.auto.AutoCriteria;
import ar.edu.uai.paradigms.dao.AutoDAO;
import ar.edu.uai.paradigms.service.AutoService;

import java.util.List;

/**
 * Created by Nicolas on 06/07/2016.
 */
public class AutoServiceImpl implements AutoService{

    private AutoDAO autoDAO;

    public AutoServiceImpl(AutoDAO autoDAO) {
        this.autoDAO = autoDAO;
    }

    @Override
    public Auto saveAuto(Auto auto) {
        return this.autoDAO.create(auto);
    }

    @Override
    public Auto retrieveAuto(Integer identifier) {
        return this.autoDAO.retrieve(identifier);
    }

    @Override
    public void deleteAuto(Integer identifier) {
        this.autoDAO.delete(identifier);
    }

    @Override
    public List<Auto> retrieveByCriteria(AutoCriteria criteria) {
        return this.autoDAO.retrieveByCriteria(criteria);
    }
}
