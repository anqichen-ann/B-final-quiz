package com.example.demo.service;

import com.example.demo.dto.Group;
import com.example.demo.dto.Trainee;
import com.example.demo.dto.Trainer;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private final TrainerService trainerService;
    private final TraineeService traineeService;

    public GroupService(TrainerService trainerService, TraineeService traineeService) {
        this.trainerService = trainerService;
        this.traineeService = traineeService;
    }
    private final List<Group> groupList = new ArrayList<>();

    public List<Group> group(){
        int TRAINER_GROUP_LENGTH = 2;
        List<Trainee> groupTrainees = traineeService.getGroupedTraineeList();
        List<Trainer> groupTrainers = trainerService.getGroupedTrainerList();
        groupList.clear();
        int groupNumber = groupTrainers.size()/2;
        int traineeLength = groupTrainees.size()/groupNumber;
        int traineeLeftNumber = groupTrainees.size() % groupNumber;
        int index = 0;
        for(int i=0; i<groupNumber; i++){
            Group group = new Group();
            List traineeList = new ArrayList<>();
            List trainerList = new ArrayList<>();
            if(index < traineeLeftNumber){
                traineeList.add(groupTrainees.subList(i*(traineeLength+1),(i+1)*(traineeLength+1)));
                index++;
            }else {
                traineeList.add(groupTrainees.subList(i*traineeLength+traineeLeftNumber,(i+1)*traineeLength+traineeLeftNumber));
            }
            trainerList.add(groupTrainers.subList(i* TRAINER_GROUP_LENGTH, (i + 1)* TRAINER_GROUP_LENGTH));
            group.setId(i+1);
            group.setName((i+1) + "组");
            group.setTrainees(traineeList);
            group.setTrainers(trainerList);
            groupList.add(group);
        }
        return groupList;

    }

    public List<Group> getGroupList(){
        return groupList;
    }
}
