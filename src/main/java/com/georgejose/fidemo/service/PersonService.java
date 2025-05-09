package com.georgejose.fidemo.service;

import com.georgejose.fidemo.model.dto.PersonDto;

import java.util.Optional;

/**
 * Service interface for Person.
 * @author George Jose
 * @version 1.0
 * @since 1.0
 */

public interface PersonService {

    /**
     * Save a person.
     * @param personDto
     * @return
     */
    PersonDto save(PersonDto personDto);

    /**
     * Find a person by id.
     * @param id
     * @return
     */
    Optional<PersonDto> findById(long id);

    /**
     * delete a person by id.
     * @param id
     */
    void deleteById(long id);

    /**
     * Find a person by first name.
     * @param firstName
     * @return
     */
    Optional<PersonDto> findByFirstName(String firstName);
}
