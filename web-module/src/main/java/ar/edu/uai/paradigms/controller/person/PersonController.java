package ar.edu.uai.paradigms.controller.person;

import ar.edu.uai.model.person.Person;
import ar.edu.uai.model.person.PersonCriteria;
import ar.edu.uai.paradigms.dto.person.PersonCriteriaDTO;
import ar.edu.uai.paradigms.dto.person.PersonDTO;
import ar.edu.uai.paradigms.service.PersonService;
import ar.edu.uai.paradigms.translator.person.PersonTranslator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Federico Donnarumma on 10/15/14.
 */

@Controller
@RequestMapping("/persons")
public class PersonController {

    public PersonController(
            PersonService personService,
            PersonTranslator personTranslator) {
        super();
        this.personService = personService;
        this.personTranslator = personTranslator;
    }

    private static final Logger LOGGER = LoggerFactory
            .getLogger(PersonController.class);

    private PersonService personService;

    private PersonTranslator personTranslator;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        LOGGER.debug("Received DTO: " + personDTO);
        Person personModel = this.personTranslator.translate(personDTO);
        Person person = this.personService.savePerson(personModel);
        PersonDTO personDTOOutput = this.personTranslator.translateToDTO(person);
        return new ResponseEntity<PersonDTO>(personDTOOutput, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<PersonDTO>> retrieveByCriteria(PersonCriteriaDTO personCriteria) {
        LOGGER.debug("Received QUERY: " + personCriteria);
        PersonCriteria criteria = this.personTranslator.translateCriteria(personCriteria);
        List<Person> persons = this.personService.retrieveByCriteria(criteria);
        List<PersonDTO> personDTOs = this.personTranslator.translateToDTO(persons);
        return new ResponseEntity<List<PersonDTO>>(personDTOs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<PersonDTO> getPerson(@PathVariable Integer identifier) throws InterruptedException {
        Person retrievedPerson = this.personService.retrievePerson(identifier);
        PersonDTO person = this.personTranslator.translateToDTO(retrievedPerson);
        if (person != null) {
            return new ResponseEntity<PersonDTO>(person, HttpStatus.OK);
        }
        return new ResponseEntity<PersonDTO>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<String> deletePerson(@PathVariable Integer identifier) {
        this.personService.deletePerson(identifier);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}