package com.ultron.systems.vehicle.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "vehicle_years")
public class Year implements Serializable {
    @Id
    private Integer year;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @PrePersist
    public void beforePersist() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void beforeUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
