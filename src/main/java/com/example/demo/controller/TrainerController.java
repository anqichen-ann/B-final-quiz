package com.example.demo.controller;

import com.example.demo.dto.Trainee;
import com.example.demo.dto.Trainer;
import com.example.demo.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trainer createTrainer(@RequestBody @Valid Trainer trainer){
        return trainerService.createTrainer(trainer);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainer(@PathVariable("id") long id){
        trainerService.deleteTrainer(id);
    }
}
