package com.ultron.systems.vehicle.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "vehicle_makes")
public class Make implements Serializable {
    @Id
    private String make;
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
