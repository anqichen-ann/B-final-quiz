package com.example.demo.service;

import com.example.demo.dto.Trainee;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TraineeService {
    private int ALL_TRAINEE_NUMBER;
    private TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
        this.ALL_TRAINEE_NUMBER = this.traineeRepository.findAll().size();
    }

    private final List<Trainee> unGroupedTraineeList = traineeRepository.findAll();
    private final List<Trainee> groupedTraineeList = new ArrayList<>();

    public List<Trainee> getUnGroupedTraineeList(){
        return this.unGroupedTraineeList;
    }

    public Trainee createTrainee(Trainee trainee){
        Trainee newTrainee = Trainee.builder()
                .id(this.ALL_TRAINEE_NUMBER + 1)
                .name(trainee.getName())
                .build();
        this.ALL_TRAINEE_NUMBER++;
        traineeRepository.save(newTrainee);
        return newTrainee;

    }



}
