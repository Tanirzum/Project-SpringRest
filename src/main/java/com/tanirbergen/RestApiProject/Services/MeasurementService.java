package com.tanirbergen.RestApiProject.Services;

import com.tanirbergen.RestApiProject.Models.Measurement;
import com.tanirbergen.RestApiProject.Repositoryes.MeasurementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    private final SensorsService sensorsService;

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    @Transactional
    public void addMeasurement(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementRepository.save(measurement);
    }

    public void enrichMeasurement(Measurement measurement) {
        measurement.setSensors(sensorsService.findByName(measurement.getSensors().getName()).get());
        measurement.setMeasurement_data_time(LocalDateTime.now());
    }
}
