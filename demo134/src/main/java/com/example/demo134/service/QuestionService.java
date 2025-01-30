package com.example.demo134.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo134.model.Questions;
import com.example.demo134.repo.QuestionRepo;
@Service
public class QuestionService {
	
	@Autowired
	public QuestionRepo questionRepo;


	public List<Questions> getAllQuetions(){
		return questionRepo.findAll();
		
	}

	public List<Questions> getQuestionByCatagory(String catagory) {
		// TODO Auto-generated method stub
		return questionRepo.findByCatagory(catagory);
	}

	public String addQuestions(Questions questions) {
		// TODO Auto-generated method stub
		questionRepo.save(questions);
		return "Question added Succesfully";
	}



}
