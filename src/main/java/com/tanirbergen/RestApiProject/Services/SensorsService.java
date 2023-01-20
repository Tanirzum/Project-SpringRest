package com.tanirbergen.RestApiProject.Services;

import com.tanirbergen.RestApiProject.Models.Sensors;
import com.tanirbergen.RestApiProject.Repositoryes.SensorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class SensorsService {

    private final SensorsRepository sensorsRepository;

    @Transactional
    public void save(Sensors sensors) {
        sensorsRepository.save(sensors);
    }

    public Optional<Sensors> findByName(String name){
        return sensorsRepository.findByName(name);
    }
}
