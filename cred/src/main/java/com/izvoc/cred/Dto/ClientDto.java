package com.izvoc.cred.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ClientDto(

        Long id, String name,
        @Size(min = 11, max = 11, message = "CPF deve ter 11 caracteres")

        String cpf,
        Double income,
        @JsonFormat(pattern = "yyyy-MM-dd")

        LocalDate birthDate,
        Integer children




) {
}
