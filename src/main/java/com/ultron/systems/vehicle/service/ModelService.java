package com.ultron.systems.vehicle.service;


import com.ultron.systems.vehicle.models.Make;
import com.ultron.systems.vehicle.models.Model;
import com.ultron.systems.vehicle.models.Year;
import com.ultron.systems.vehicle.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
    private final ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public boolean exists(String model, Make make, Year year) {
        return modelRepository.existsByModelAndMakeAndYear(model, make, year);
    }

    public Model save(Model model) {
        return modelRepository.save(model);
    }
}
