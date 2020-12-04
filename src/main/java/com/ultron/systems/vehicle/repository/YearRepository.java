package com.ultron.systems.vehicle.repository;

import com.ultron.systems.vehicle.models.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository extends JpaRepository<Year, Integer> {
}
