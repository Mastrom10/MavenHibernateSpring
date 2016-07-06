package ar.edu.uai.paradigms.translator.auto;

import ar.edu.uai.model.auto.Auto;
import ar.edu.uai.model.auto.AutoCriteria;
import ar.edu.uai.paradigms.dto.auto.AutoCriteriaDTO;
import ar.edu.uai.paradigms.dto.auto.AutoDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 06/07/2016.
 */
public class AutoTranslator {

    public Auto translate(AutoDTO autoDTO) {
        return new Auto(autoDTO.getId(), autoDTO.getMarca(), autoDTO.getModelo());
    }

    public AutoDTO translateToDTO(Auto auto) {
        if (auto != null) {
            return new AutoDTO(auto.getId(), auto.getMarca(), auto.getModelo());
        }
        return null;
    }

    public List<AutoDTO> translateToDTO(List<Auto> autos) {
        List<AutoDTO> autoResponse = new ArrayList<AutoDTO>();
        for(Auto p : autos) {
            AutoDTO autoDTO = this.translateToDTO(p);
            if(autoDTO != null) {
                autoResponse.add(autoDTO);
            }
        }
        return autoResponse;
    }

    public AutoCriteria translateCriteria(AutoCriteriaDTO autoCriteriaDTO) {
        return new AutoCriteria(autoCriteriaDTO.getMarca(), autoCriteriaDTO.getMinModelo(), autoCriteriaDTO.getMaxModelo());
    }
}
