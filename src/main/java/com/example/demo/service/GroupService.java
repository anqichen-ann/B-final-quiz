package com.example.demo.service;

import com.example.demo.dto.Group;
import com.example.demo.dto.Trainee;
import com.example.demo.dto.Trainer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    // TODO GTB-知识点: - Service之间不应该互相调用
    private final TrainerService trainerService;
    private final TraineeService traineeService;

    public GroupService(TrainerService trainerService, TraineeService traineeService) {
        this.trainerService = trainerService;
        this.traineeService = traineeService;
    }
    private final List<Group> groupList = new ArrayList<>();

    // TODO GTB-工程实践: - 长方法，可以抽成多个方法提高可读性
    public List<Group> group(){
        // TODO GTB-工程实践: - 常量的声明位置错误
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
            List<Trainee> traineeList = new ArrayList<>();
            List<Trainer> trainerList;
            if(index < traineeLeftNumber){
                traineeList.addAll(groupTrainees.subList(i*(traineeLength+1),(i+1)*(traineeLength+1)));
                index++;
            }else {
                traineeList.addAll(groupTrainees.subList(i*traineeLength+traineeLeftNumber,(i+1)*traineeLength+traineeLeftNumber));
            }
            trainerList = groupTrainers.subList(i* TRAINER_GROUP_LENGTH, (i + 1)* TRAINER_GROUP_LENGTH);
            group.setId(i+1);
            // TODO GTB-工程实践: - Magic Number
            group.setName((i+1) + "组");
            // TODO GTB-工程实践: - 注意代码风格，应该加入适量空格
            group.setTrainees(traineeList);
            group.setTrainers(trainerList);
            groupList.add(group);
        }
        return groupList;

    }

    // TODO GTB-完成度: - 组信息没有使用数据库保存
    public List<Group> getGroupList(){
        return groupList;
    }
}
