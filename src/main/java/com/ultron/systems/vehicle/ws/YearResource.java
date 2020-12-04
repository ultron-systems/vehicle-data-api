package com.ultron.systems.vehicle.ws;

import com.ultron.systems.vehicle.config.ApiDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
@RequestMapping(value = "years")
public class YearResource {

    @GetMapping
    public ResponseEntity index() {
        return ResponseEntity.ok("ddd");
    }
}
