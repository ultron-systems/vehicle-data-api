package com.ultron.systems.vehicle.repository;

import com.ultron.systems.vehicle.models.Make;
import com.ultron.systems.vehicle.models.Model;
import com.ultron.systems.vehicle.models.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    boolean existsByModelAndMakeAndYear(String model, Make make, Year year);
}
