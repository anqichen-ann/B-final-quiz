package com.example.demo;

import com.example.demo.dto.Trainee;
import com.example.demo.dto.Trainer;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

@SpringBootApplication
@Order(value=2)
public class FinalQuizApplication implements ApplicationRunner {
	@Autowired
	private TraineeRepository traineeRepository;
	@Autowired
	private TrainerRepository trainerRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinalQuizApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}
}
