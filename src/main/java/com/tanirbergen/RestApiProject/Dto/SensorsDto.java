package com.tanirbergen.RestApiProject.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SensorsDto {

    @NotEmpty
    @Size(min = 3, max = 30, message = "Имя должен быть от 3 до 30 букв")
    private String name;
}
