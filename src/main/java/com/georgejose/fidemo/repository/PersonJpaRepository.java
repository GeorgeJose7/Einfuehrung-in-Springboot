package com.georgejose.fidemo.repository;

import com.georgejose.fidemo.model.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Jpa Repository for Person.
 * @author George Jose
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {


    @Query(value = "SELECT * from person where id = ?1", nativeQuery = true)
    PersonEntity findById(long id);

    @Query(value = "DELETE from person where id = ?1", nativeQuery = true)
    void deleteById(long id);

    @Query(value = "SELECT * from person where first_name = ?1", nativeQuery = true)
    PersonEntity findByFirstName(String firstName);

}
