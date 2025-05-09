package com.georgejose.fidemo.model.entity;

import jakarta.persistence.*;

/**
 * Enity class for Person.
 *
 * @author George Jose
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "person")
public class PersonEntity {

    public PersonEntity() {
    }

    public PersonEntity(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String firstName;
    String lastName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
