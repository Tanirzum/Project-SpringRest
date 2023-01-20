package com.tanirbergen.RestApiProject.Util;

import com.tanirbergen.RestApiProject.Models.Sensors;
import com.tanirbergen.RestApiProject.Services.SensorsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@AllArgsConstructor
@Component
public class SensorsValidator implements Validator {

    private final SensorsService sensorsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensors.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensors sensors = (Sensors) target;

        if (sensorsService.findByName(sensors.getName()).isPresent()) {
            errors.rejectValue("name", "", "Сенсор с таким названием уже существует");
        }
    }
}
