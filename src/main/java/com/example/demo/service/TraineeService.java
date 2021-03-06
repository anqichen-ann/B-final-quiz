package com.example.demo.service;

import com.example.demo.dto.Trainee;
import com.example.demo.exception.GroupFailedException;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TraineeService {
    // TODO GTB-工程实践: - 变量不符合命名规范，应该小写
    private int ALL_TRAINEE_NUMBER = 0;
    private final TraineeRepository traineeRepository;
    private  List<Trainee> unGroupedTraineeList = new ArrayList<>();
    private  List<Trainee> groupedTraineeList = new ArrayList<>();

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
        // TODO GTB-工程实践: - 初始化数据建议不要耦合在代码中
        String[] traineeList = {
                "成吉思汗", "鲁班七号", "太乙真人",
                "钟无艳", "花木兰", "雅典娜",
                "芈月", "白起", "刘禅",
                "庄周", "马超", "刘备",
                "哪吒", "大乔", "蔡文姬"
        };

        //TODO 使用Java8 stream
        // TODO GTB-知识点: - 可以使用Java8 Stream API
        for (int i = 0; i < traineeList.length; i++) {
            Trainee trainee = Trainee.builder()
                    .id(i + 1)
                    .name(traineeList[i])
                    .build();
            this.traineeRepository.save(trainee);
        }

        this.ALL_TRAINEE_NUMBER = this.traineeRepository.findAll().size();
        if(this.ALL_TRAINEE_NUMBER != 0)
        {
            this.unGroupedTraineeList = this.traineeRepository.findAll();
        }
    }



    public List<Trainee> getUnGroupedTraineeList(){
        // TODO GTB-知识点: - 每次请求应该从数据库查询数据
        return this.unGroupedTraineeList;
    }

    public Trainee createTrainee(Trainee trainee){
        Trainee newTrainee = Trainee.builder()
                .id(this.ALL_TRAINEE_NUMBER + 1)
                .name(trainee.getName())
                .build();
        this.ALL_TRAINEE_NUMBER++;
        traineeRepository.save(newTrainee);
        this.unGroupedTraineeList.add(newTrainee);
        return newTrainee;

    }

    public void deleteTrainee(long id){
        Optional<Trainee> trainee = traineeRepository.findById(id);
        // TODO GTB-工程实践: - 异常最好使用Exception结尾
        trainee.orElseThrow(() -> new ResourceNotFound("学员不存在"));
        traineeRepository.deleteById(id);
    }

    public List<Trainee> getGroupedTraineeList(){
        groupedTraineeList = traineeRepository.findAll();
        if (groupedTraineeList.size() < 1){
            throw new GroupFailedException("分组失败");
        }
        Collections.shuffle(groupedTraineeList);
        // TODO GTB-工程实践: - 所有数据状态都应该维护在数据库中，不要进行这种内存操作
        unGroupedTraineeList.clear();
        return groupedTraineeList;
    }



}
