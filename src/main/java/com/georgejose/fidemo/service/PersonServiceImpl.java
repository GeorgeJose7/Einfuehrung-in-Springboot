package com.georgejose.fidemo.service;

import com.georgejose.fidemo.model.dto.PersonDto;
import com.georgejose.fidemo.model.entity.PersonEntity;
import com.georgejose.fidemo.repository.PersonJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * Service implementation for Person.
 *
 * @author George Jose
 * @version 1.0
 * @since 1.0
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonJpaRepository personJpaRepository;

    public PersonServiceImpl(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        Objects.requireNonNull(personDto, "PersonDto cannot be null");
        PersonEntity personEntity = mapToPersonEntity(personDto);
        PersonEntity savedEntity = personJpaRepository.save(personEntity);

        return mapToPersonDto(savedEntity);

    }

    @Override
    public Optional<PersonDto> findById(long id) {
        Objects.requireNonNull(id, "Id cannot be null");
        PersonEntity personEntity = personJpaRepository.findById(id);
        if (personEntity == null) {
            return Optional.empty();
        }
        return Optional.of(mapToPersonDto(personEntity));
    }

    @Override
    public void deleteById(long id) {
        Objects.requireNonNull(id, "Id cannot be null");
        personJpaRepository.deleteById(id);
    }

    @Override
    public Optional<PersonDto> findByFirstName(String firstName) {
        Objects.requireNonNull(firstName, "First name cannot be null");
        PersonEntity personEntity = personJpaRepository.findByFirstName(firstName);
        if (personEntity == null) {
            return Optional.empty();
        }
        return Optional.of(mapToPersonDto(personEntity));
    }

    private PersonDto mapToPersonDto(PersonEntity personEntity) {
        return new PersonDto(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName()
        );
    }

    private PersonEntity mapToPersonEntity(PersonDto personDto) {
        PersonEntity personEntity = new PersonEntity();
        if (null != personDto.id()) {
            personEntity.setId(personDto.id());
        }
        personEntity.setFirstName(personDto.firstName());
        personEntity.setLastName(personDto.lastName());
        return personEntity;


    }
}
