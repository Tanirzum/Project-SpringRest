package com.tanirbergen.RestApiProject.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "measurement")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @Min(-100)
    @Max(100)
    @NotNull
    private Double value;

    @Column(name = "raining")
    @NotNull
    private boolean raining;

    @Column(name = "measurement_data_time")
    @NotNull
    private LocalDateTime measurement_data_time;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    private Sensors sensors;
}
