package com.example.demo134.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo134.model.Questions;



@Repository
public interface QuestionRepo extends JpaRepository<Questions, Integer>{
	
	List<Questions> findByCatagory(String catagory);
	
	 @Query(value = "SELECT * FROM questions q WHERE q.catagory = :catagory ORDER BY RANDOM() LIMIT :noQ", nativeQuery = true)
	 List<Questions> findRandomQuestionsByCategory(@Param("catagory") String category, @Param("noQ") int noQ);
	
	@Query(value = "SELECT * FROM questions q WHERE q.catagory = :catagory ORDER BY RANDOM() LIMIT :noQ", nativeQuery = true)
	List<Questions> findRandonQuestionsByCatagory(String catagory, int noQ);
	
	

}
