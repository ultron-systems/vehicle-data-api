package com.ultron.systems.vehicle.repository;

import com.ultron.systems.vehicle.models.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeRepository extends JpaRepository<Make, String> {
}
