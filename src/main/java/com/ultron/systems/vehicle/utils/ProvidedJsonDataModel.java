package com.ultron.systems.vehicle.utils;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProvidedJsonDataModel implements Serializable {
    private Integer year;
    private String make;
    private String model;
}
