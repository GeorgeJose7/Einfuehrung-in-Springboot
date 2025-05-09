package com.georgejose.fidemo.controller;

import ch.qos.logback.classic.Logger;
import com.georgejose.fidemo.model.dto.PersonDto;
import com.georgejose.fidemo.model.dto.SavePersonDto;
import com.georgejose.fidemo.service.PersonService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller class for Person.
 * @author George Jose
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/person")

public class PersonController {

    Logger logger = (Logger) LoggerFactory.getLogger(PersonController.class);

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Save a person with a post request
     * @param personDto
     * @return
     */
    @PostMapping
    public ResponseEntity<PersonDto> savePerson(@RequestBody SavePersonDto personDto) {

        var internalDto = new PersonDto(
                null,
                personDto.firstName(),
                personDto.lastName()
        );
        personService.save(internalDto);
    return     ResponseEntity.ok(internalDto);
    }


    /**
     * Find a person by id with a get request
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findPersonById(@PathVariable String id) {
        var personDto = personService.findById(Long.parseLong(id));
        if (personDto.isEmpty()) {
            logger.debug("Person not found with id: {}", id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personDto.get());

    }


    /**
     * Delete a person by id with a delete request
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonById(@PathVariable String id) {
        personService.deleteById(Long.parseLong(id));
        return ResponseEntity.noContent().build();

    }

    /**
     * Find a person by first name with a get request
     * @param firstName
     * @return
     */
    @GetMapping("/findByFirstName")
    public ResponseEntity<PersonDto> findPersonByFirstName(
            @RequestParam(value = "firstName", required = true) String firstName) {
        Optional<PersonDto> byFirstName = personService.findByFirstName(firstName);
        if (byFirstName.isEmpty()) {
            logger.debug("Person not found with first name: {}", firstName);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byFirstName.get());
    }



}
