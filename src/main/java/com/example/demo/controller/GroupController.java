package com.example.demo.controller;

import com.example.demo.dto.Group;
import com.example.demo.dto.Trainee;
import com.example.demo.dto.Trainer;
import com.example.demo.exception.GroupFailedException;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import com.example.demo.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/auto-grouping")
    public List<Group> group(){
        return groupService.group();
    }

    @GetMapping
    public List<Group> getGroup(){
        return groupService.getGroupList();
    }
}
