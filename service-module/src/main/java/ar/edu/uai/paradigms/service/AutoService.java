package ar.edu.uai.paradigms.service;

import ar.edu.uai.model.auto.Auto;
import ar.edu.uai.model.auto.AutoCriteria;

import java.util.List;

/**
 * Created by Nicolas on 06/07/2016.
 */
public interface AutoService {

    Auto saveAuto(Auto auto);

    Auto retrieveAuto(Integer identifier);

    void deleteAuto(Integer identifier);

    List<Auto> retrieveByCriteria(AutoCriteria criteria);


}
