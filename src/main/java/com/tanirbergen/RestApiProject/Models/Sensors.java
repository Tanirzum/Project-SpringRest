package com.tanirbergen.RestApiProject.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "sensors")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sensors {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @Size(min = 3, max = 30, message = "Имя должен быть от 3 до 30 букв")
    @NotEmpty(message = "Название не должно быть пустым")
    private String name;
}
