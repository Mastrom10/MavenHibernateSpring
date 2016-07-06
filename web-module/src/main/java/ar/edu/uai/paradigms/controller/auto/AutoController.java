package ar.edu.uai.paradigms.controller.auto;

import ar.edu.uai.model.auto.Auto;
import ar.edu.uai.model.auto.AutoCriteria;
import ar.edu.uai.paradigms.dto.auto.AutoCriteriaDTO;
import ar.edu.uai.paradigms.dto.auto.AutoDTO;
import ar.edu.uai.paradigms.service.AutoService;
import ar.edu.uai.paradigms.translator.auto.AutoTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Nicolas on 06/07/2016.
 */

@Controller
@RequestMapping("/autos")
public class AutoController {

    public AutoController(
            AutoService autoService,
            AutoTranslator autoTranslator) {
        super();
        this.autoService = autoService;
        this.autoTranslator = autoTranslator;
    }

    private static final Logger LOGGER = LoggerFactory
            .getLogger(AutoController.class);

    private AutoService autoService;

    private AutoTranslator autoTranslator;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    ResponseEntity<AutoDTO> createAuto(@RequestBody AutoDTO autoDTO) {
        LOGGER.debug("Received DTO: " + autoDTO);
        Auto autoModel = this.autoTranslator.translate(autoDTO);
        Auto auto = this.autoService.saveAuto(autoModel);
        AutoDTO autoDTOOutput = this.autoTranslator.translateToDTO(auto);
        return new ResponseEntity<AutoDTO>(autoDTOOutput, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<AutoDTO>> retrieveByCriteria(AutoCriteriaDTO autoCriteria) {
        LOGGER.debug("Received QUERY: " + autoCriteria);
        AutoCriteria criteria = this.autoTranslator.translateCriteria(autoCriteria);
        List<Auto> autos = this.autoService.retrieveByCriteria(criteria);
        List<AutoDTO> autoDTOs = this.autoTranslator.translateToDTO(autos);
        return new ResponseEntity<List<AutoDTO>>(autoDTOs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<AutoDTO> getAuto(@PathVariable Integer identifier) throws InterruptedException {
        Auto retrievedAuto = this.autoService.retrieveAuto(identifier);
        AutoDTO auto = this.autoTranslator.translateToDTO(retrievedAuto);
        if (auto != null) {
            return new ResponseEntity<AutoDTO>(auto, HttpStatus.OK);
        }
        return new ResponseEntity<AutoDTO>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<String> deleteAuto(@PathVariable Integer identifier) {
        this.autoService.deleteAuto(identifier);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
