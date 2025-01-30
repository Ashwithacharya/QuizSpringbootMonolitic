package com.example.demo134.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo134.model.Quiz;
import com.example.demo134.model.Response;
import com.example.demo134.repo.QuestionRepo;
import com.example.demo134.repo.QuizRepo;
import com.example.demo134.model.QuestionWrapper;
import com.example.demo134.model.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
	
	@Autowired
	QuizRepo quizRepo;
	
	@Autowired
	QuestionRepo questionRepo;

	

	public String createQuiz(String catagory, int noQ, String title) {
		// TODO Auto-generated method stub
		List<Questions> questions=questionRepo.findRandonQuestionsByCatagory(catagory, noQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizRepo.save(quiz);
		
		return "Quiz added SuccessFully";
	}



	public List<QuestionWrapper> getQuizQuestion(int id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz=quizRepo.findById(id);
		List<Questions> questionsFromDB=quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser= new ArrayList<>();
		for(Questions q:questionsFromDB) {
			QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(qw);
		}
		return questionsForUser;
	}



	public int calaculateResult(int id, List<Response> responses) {
		// TODO Auto-generated method stub
		Quiz quiz=quizRepo.findById(id).get();
		List<Questions> questions=quiz.getQuestions();
		int right=0;
		int i=0;
		for(Response response:responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
				right++;
				i++;
			}
		}
		return right;
	}
	
	
}
