package com.example.demo.service;

import com.example.demo.dto.Trainee;
import com.example.demo.dto.Trainer;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {
    private int ALL_TRAINER_NUMBER = 0;
    private List<Trainer> unGroupedTrainerList = new ArrayList<>();
    private final List<Trainer> groupedTrainerList = new ArrayList<>();
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
        String[] trainerList = {
                "王晓峰","张巍","张钊","朱玉前",
                "杜娟","彭梦秋","董志刚","周丽","程龙举"
        };
        for (int i = 0; i < trainerList.length; i++) {
            Trainer trainer = Trainer.builder()
                    .id(i + 1)
                    .name(trainerList[i])
                    .build();
            this.trainerRepository.save(trainer);
        }
        this.ALL_TRAINER_NUMBER = this.trainerRepository.findAll().size();
        if(this.ALL_TRAINER_NUMBER != 0)
        {
            this.unGroupedTrainerList = this.trainerRepository.findAll();
        }
    }

    public List<Trainer> getUnGroupedTrainerList(){
        return this.unGroupedTrainerList;
    }
}
