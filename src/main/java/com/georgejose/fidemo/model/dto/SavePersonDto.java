package com.georgejose.fidemo.model.dto;

/**
 * Data Transfer Object (DTO) for Person.
 * @author George Jose
 * @version 1.0
 * @since 1.0
 */

public record SavePersonDto(
    String firstName,
    String lastName
) {
}
