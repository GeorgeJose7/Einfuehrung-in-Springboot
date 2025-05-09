package com.georgejose.fidemo.model.dto;

import jakarta.annotation.Nullable;

/**
 * Data Transfer Object (DTO) for Person.
 * @author George Jose
 * @version 1.0
 * @since 1.0
 */
public record PersonDto (

   @Nullable Long id,
    String firstName,
    String lastName
){}
