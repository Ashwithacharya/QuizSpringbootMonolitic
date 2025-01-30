package com.example.demo134.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo134.model.QuestionWrapper;
import com.example.demo134.model.Questions;
import com.example.demo134.model.Response;
import com.example.demo134.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String catagory ,@RequestParam int noQ, @RequestParam String title){
		return new ResponseEntity<>(quizService.createQuiz(catagory,noQ,title),HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable int id){
		return new ResponseEntity<>(quizService.getQuizQuestion(id),HttpStatus.OK);
		
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
		return new ResponseEntity<>(quizService.calaculateResult(id,responses),HttpStatus.OK);		
	}
		
}


