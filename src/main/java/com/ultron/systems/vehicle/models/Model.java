package com.ultron.systems.vehicle.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "vehicle_models")
public class Model implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String model;

    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year;
}
