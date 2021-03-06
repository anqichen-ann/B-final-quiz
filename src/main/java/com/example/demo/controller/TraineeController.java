package com.example.demo.controller;

import com.example.demo.dto.Trainee;
import com.example.demo.service.TraineeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/trainees")
public class TraineeController {
    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping
    // TODO GTB-工程实践: - 未使用的方法参数
    // TODO GTB-知识点: - 了解下@GetMapping的params属性
    public List<Trainee> getUnGroupedTrainee(@RequestParam("grouped") Boolean Grouped){
        return traineeService.getUnGroupedTraineeList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trainee createTrainee(@RequestBody @Valid Trainee trainee){
        return traineeService.createTrainee(trainee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainee(@PathVariable("id") long id){
        traineeService.deleteTrainee(id);
    }
}
