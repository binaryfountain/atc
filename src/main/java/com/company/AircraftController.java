package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping("/list")
    public List<Aircraft> list() {
        return aircraftService.list();
    }

    @GetMapping("/enqueue")
    public Aircraft enqueue(Aircraft aircraft) {
        return aircraftService.enqueue(aircraft);
    }

    @GetMapping("/dequeue")
    public Aircraft dequeue() {
        return aircraftService.dequeue();
    }

}