package com.ultron.systems.vehicle.service;

import com.ultron.systems.vehicle.models.Year;
import com.ultron.systems.vehicle.repository.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YearService {
    private final YearRepository yearRepository;

    @Autowired
    public YearService(YearRepository yearRepository) {
        this.yearRepository = yearRepository;
    }

    public boolean exists(Integer year) {
        return yearRepository.existsById(year);
    }

    public Year save(Year year) {
        return yearRepository.save(year);
    }
}
