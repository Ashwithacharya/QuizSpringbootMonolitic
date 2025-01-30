package com.example.demo134.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo134.model.Quiz;


@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {
	
	

}
