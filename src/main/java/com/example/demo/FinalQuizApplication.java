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

//	@Override
//	public void run(String... args) throws Exception {
//
//
//
//	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String[] traineeList = {
				"成吉思汗", "鲁班七号", "太乙真人",
				"钟无艳", "花木兰", "雅典娜",
				"芈月", "白起", "刘禅",
				"庄周", "马超", "刘备",
				"哪吒", "大乔", "蔡文姬"
		};

		//TODO 使用Java8 stream
		for (int i = 0; i < traineeList.length; i++) {
			Trainee trainee = Trainee.builder()
					.id(i + 1)
					.name(traineeList[i])
					.build();
			traineeRepository.save(trainee);
		}
		String[] trainerList = {
				"王晓峰","张巍","张钊","朱玉前",
				"杜娟","彭梦秋","董志刚","周丽","程龙举"
		};
		for (int i = 0; i < trainerList.length; i++) {
			Trainer trainer = Trainer.builder()
					.id(i + 1)
					.name(trainerList[i])
					.build();
			trainerRepository.save(trainer);
		}
	}
}
