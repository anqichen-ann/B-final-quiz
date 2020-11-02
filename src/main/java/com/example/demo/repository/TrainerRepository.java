package com.example.demo.repository;

import com.example.demo.dto.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO GTB-知识点: - 继承JPA接口时不需要加@Repository
@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
