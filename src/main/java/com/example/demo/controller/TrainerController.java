package com.example.demo.controller;

import com.example.demo.dto.Trainer;
import com.example.demo.service.TrainerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<Trainer> getUngroupedTrainer(@RequestParam("grouped") Boolean Grouped){
        return trainerService.getUnGroupedTrainerList();
    }


}
