package com.example.demo134.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.demo134.service.QuestionService;
import com.example.demo134.model.Questions;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	public QuestionService questionService;
	
		

	@GetMapping("/allQuestions")
	public ResponseEntity<List<Questions>> getAllQuestion() {
		return new ResponseEntity<>(questionService.getAllQuetions(),HttpStatus.OK);
		
	}
	
	@GetMapping("/catagory/{catagory}")
	public ResponseEntity<List<Questions>> getQuestionByCatagory(@PathVariable String catagory){
	      return new ResponseEntity<>(questionService.getQuestionByCatagory(catagory),HttpStatus.OK);	
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestions(@RequestBody Questions questions){
		return new ResponseEntity<>(questionService.addQuestions(questions),HttpStatus.OK);
		
	}
	

}
