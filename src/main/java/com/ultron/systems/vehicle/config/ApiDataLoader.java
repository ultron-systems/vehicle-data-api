package com.ultron.systems.vehicle.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ultron.systems.vehicle.models.Make;
import com.ultron.systems.vehicle.models.Model;
import com.ultron.systems.vehicle.models.Year;
import com.ultron.systems.vehicle.service.MakeService;
import com.ultron.systems.vehicle.service.ModelService;
import com.ultron.systems.vehicle.service.YearService;
import com.ultron.systems.vehicle.utils.ProvidedJsonDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class ApiDataLoader {
    private final Logger logger;
    private final YearService yearService;
    private final MakeService makeService;
    private final ModelService modelService;

    @Autowired
    public ApiDataLoader(YearService yearService, MakeService makeService, ModelService modelService) {
        this.yearService = yearService;
        this.makeService = makeService;
        this.modelService = modelService;
        this.logger = LoggerFactory.getLogger(ApiDataLoader.class);
    }

    @Bean
    public void loadDisposedData() throws IOException {
        File file = ResourceUtils.getFile("classpath:data/disposed_data.json");
        if (file.canRead()) {
           Files.lines(file.toPath())
                .map(this::transformLine).filter(p -> p != null)
                .forEach(this::saveModel);
        } else {
            logger.error(String.format("File %s is not readable.", file.toPath().toString()));
        }
    }

    private ProvidedJsonDataModel transformLine(String line) {
        // Prevent invalid lines transformation
        if (line.trim().length() == 1) {
            return null;
        }

        // Transform line to Object
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(line, ProvidedJsonDataModel.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return  null;
        }
    }

    private void saveModel(ProvidedJsonDataModel providedModel) {
        Year  year  = new Year();
        Make  make  = new Make();
        Model model = new Model();

        year.setYear(providedModel.getYear());
        make.setMake(providedModel.getMake());
        model.setYear(year);
        model.setMake(make);
        model.setModel(providedModel.getModel());

        if (!yearService.exists(providedModel.getYear())) {
            yearService.save(year);
        }

        if (!makeService.exists(providedModel.getMake())) {
            makeService.save(make);
        }

        if (!modelService.exists(providedModel.getModel(), make, year)) {
            modelService.save(model);
        }

        logger.info("Line " + model + " saved ...");
    }
}
