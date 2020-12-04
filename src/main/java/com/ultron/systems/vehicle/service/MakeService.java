package com.ultron.systems.vehicle.service;

import com.ultron.systems.vehicle.models.Make;
import com.ultron.systems.vehicle.repository.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakeService {
    private final MakeRepository makeRepository;

    @Autowired
    public MakeService(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    public boolean exists(String make) {
        return makeRepository.existsById(make);
    }

    public Make save(Make make) {
        return makeRepository.save(make);
    }
}
