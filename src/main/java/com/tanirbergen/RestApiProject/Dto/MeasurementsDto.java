package com.tanirbergen.RestApiProject.Dto;

import com.tanirbergen.RestApiProject.Models.Sensors;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MeasurementsDto {

    @Min(-100)
    @Max(100)
    @NotNull
    private Double value;

    @NotNull
    private boolean raining;

    @NotNull
    private Sensors sensors;
}
