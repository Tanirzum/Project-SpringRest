package com.tanirbergen.RestApiProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class MeasurementsResponse {

    private List<MeasurementsDto> measurements;
}
