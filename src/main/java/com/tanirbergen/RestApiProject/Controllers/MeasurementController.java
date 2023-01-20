package com.tanirbergen.RestApiProject.Controllers;

import com.tanirbergen.RestApiProject.Dto.MeasurementsDto;
import com.tanirbergen.RestApiProject.Dto.MeasurementsResponse;
import com.tanirbergen.RestApiProject.Models.Measurement;
import com.tanirbergen.RestApiProject.Services.MeasurementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
@AllArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;
    private final ModelMapper modelMapper;


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementsDto measurementDto, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            System.out.println("Error - 2");
        }
        Measurement convertToAddMeasurement = convertToDto(measurementDto);
        measurementService.addMeasurement(convertToAddMeasurement);

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping()
    public MeasurementsResponse getMeasurements() {
        return new MeasurementsResponse(measurementService.findAll().stream().map(this::convertToMeasurement)
                .collect(Collectors.toList()));
    }

    @GetMapping("/rainyDaysCount")
    public Long getRainyDaysCount() {
        return measurementService.findAll().stream().filter(Measurement::isRaining).count();
    }

    public Measurement convertToDto(MeasurementsDto measurementDto) {
        return modelMapper.map(measurementDto, Measurement.class);
    }

    public MeasurementsDto convertToMeasurement(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementsDto.class);
    }
}
