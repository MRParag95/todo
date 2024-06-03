package com.mendax47.todo.user.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record UserRequestDto(
        Long id,

        @NotNull(message = "firstName can't be null.")
        @NotEmpty(message = "firstName can't be empty.")
        @NotBlank(message = "firstName can't be blank.")
        String firstName,

        @NotNull(message = "lastName can't be null.")
        @NotEmpty(message = "lastName can't be empty.")
        @NotBlank(message = "lastName can't be blank.")
        String lastName,

        @NotNull(message = "email can't be null.")
        @Email(message = "Invalid email address.")
        @NotEmpty(message = "email can't be empty.")
        @NotBlank(message = "email can't be blank.")
        String email,

        @NotNull(message = "username can't be null.")
        @NotEmpty(message = "username can't be empty.")
        @NotBlank(message = "username can't be blank.")
        String username,

        @NotNull(message = "password can't be null.")
        @NotEmpty(message = "password can't be empty.")
        @NotBlank(message = "password can't be blank.")
        String password,

        Long taskId
) implements Serializable {
}