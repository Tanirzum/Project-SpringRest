package com.tanirbergen.RestApiProject.Controllers;

import com.tanirbergen.RestApiProject.Dto.SensorsDto;
import com.tanirbergen.RestApiProject.Models.Sensors;
import com.tanirbergen.RestApiProject.Services.SensorsService;
import com.tanirbergen.RestApiProject.Util.SensorsValidator;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensors")
@AllArgsConstructor
public class SensorsController {

    private final SensorsService sensorsService;

    private final SensorsValidator sensorsValidator;

    private final ModelMapper modelMapper;

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration( @RequestBody @Valid SensorsDto sensorsDto,
                                                   BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("Error - 1");
        }

        Sensors sensorsConvertDto = convertToSensor(sensorsDto);

        sensorsValidator.validate(sensorsConvertDto, bindingResult);
        sensorsService.save(sensorsConvertDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    public Sensors convertToSensor(SensorsDto sensorsDto) {
        return modelMapper.map(sensorsDto, Sensors.class);
    }
}
