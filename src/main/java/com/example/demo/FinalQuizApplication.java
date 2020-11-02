package com.example.demo;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO GTB-工程实践: * 分包合理
// TODO GTB-知识点: * 对三层架构的掌握不错
// TODO GTB-知识点: * 对RESTful实践的掌握不错
// TODO GTB-知识点: * 对Spring MVC注解的掌握不错
// TODO GTB-知识点: * 对异常处理的掌握不错
// TODO GTB-完成度: * 功能都完成了，well down
// TODO GTB-测试: * 无测试
@SpringBootApplication
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
